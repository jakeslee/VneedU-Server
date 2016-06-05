package asia.gkc.vneedu.controller.api.v1_0;

import asia.gkc.vneedu.authorization.annotation.ActiveUser;
import asia.gkc.vneedu.authorization.annotation.RequireLogin;
import asia.gkc.vneedu.common.ResultModel;
import asia.gkc.vneedu.common.ResultStatus;
import asia.gkc.vneedu.common.property.CdnProperties;
import asia.gkc.vneedu.controller.core.BaseController;
import asia.gkc.vneedu.model.File;
import asia.gkc.vneedu.model.User;
import asia.gkc.vneedu.model.UserFile;
import asia.gkc.vneedu.storage.Storage;
import asia.gkc.vneedu.utils.GenerationUtil;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * File Name: FileController.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 4/8/16 10:57 AM
 */
@RestController
@RequestMapping(value = "/api/v1.0")
public class FileController extends BaseController {
    @Autowired
    private CdnProperties cdnProperties;

    @Autowired
    private Storage storage;

    /**
     * 将文件存储到存储器
     *
     * @param file - 文件
     * @param user - 用户信息
     * @return 用户文件模型
     */
    private UserFile saveFileToStorage(MultipartFile file, User user) {
        if (!file.isEmpty()) {
            try {
                logger.info("Checking existence: " + cdnProperties.getBucket());

                String fileHash = GenerationUtil.generateSha1ChecksumOfFile(file.getInputStream());
                File saved_file = fileService.searchFileViaHash(fileHash);

                if (saved_file == null) {
                    logger.info("File not exists!");
                    logger.info("Saving file: " + file.getOriginalFilename());
                    logger.info("File type: " + file.getContentType());

                    logger.info("Saving to bucket: " + cdnProperties.getBucket());

                    // 将文件存储到存储器中
                    String key = storage.uploadFile(file.getBytes(), null, file.getContentType());

                    if (key == null)
                        return null;

                    // 构造File信息
                    saved_file = new File();                                // 文件元信息
                    saved_file.setMime(file.getContentType());              // 设置文件类型
                    saved_file.setFilename(file.getOriginalFilename());     // 设置原始文件名（可以忽略）
                    saved_file.setLocation(key);                            // 设置保存的key
                    saved_file.setHash(fileHash);                           // 设置文件哈希
                    saved_file.setSize(file.getSize());                     // 设置文件大小

                    fileService.addObjectWithoutNull(saved_file);
                }

                // 关联到用户
                UserFile userFile = new UserFile();
                userFile.setHash(fileHash);
                userFile.setDatetime(new Date());
                userFile.setDisplayName(file.getOriginalFilename());
                userFile.setFileId(saved_file.getId());
                userFile.setUploaderId(user.getId());
                userFile.setUrl(storage.getUri(saved_file.getLocation()));

                userFileService.addObjectWithoutNull(userFile);

                return userFile;
            } catch (IOException e) {
                logger.warn("IOException: " + file.getName());
            }
        }
        return null;
    }

    /**
     * 文件上传接口
     *
     * @param files - 文件列表
     * @param user - 当前登录的用户
     * @return 结果
     */
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
    @RequireLogin
    public ResultModel upload_file(@RequestParam("files") MultipartFile[] files, @ActiveUser User user) {
        List<Map<String, Object>> filesList = new ArrayList<>();

        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                UserFile userFile = saveFileToStorage(file, user);

                if (userFile != null) {
                    filesList.add(new StringMap()
                            .put("userfile_id", userFile.getId())
                            .put("file_id", userFile.getFileId())
                            .put("sha1", userFile.getHash()).map());
                }
            }
            return ResultModel.SUCCESS(new StringMap()
                    .put("files", filesList).put("count", filesList.size()).map());
        }

        return ResultModel.ERROR(ResultStatus.EMPTY_FILE);
    }

}
