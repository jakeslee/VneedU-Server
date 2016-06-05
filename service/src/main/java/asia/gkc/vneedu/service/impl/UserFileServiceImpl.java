package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.model.File;
import asia.gkc.vneedu.model.UserFile;
import asia.gkc.vneedu.repository.FileMapper;
import asia.gkc.vneedu.repository.UserFileMapper;
import asia.gkc.vneedu.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File Name: UserFileServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/8/16 10:41 AM
 */

@Service
public class UserFileServiceImpl extends BaseService<UserFile> implements UserFileService {
    @Autowired
    private UserFileMapper userFileMapper;
    @Autowired
    private FileMapper fileMapper;

    /**
     * 获取文件模型
     *
     * @param id - 用户文件ID
     * @return 文件模型
     */
    @Override
    public File getFileByUserFileId(String id) {
        UserFile userFile = userFileMapper.selectByPrimaryKey(id);

        return fileMapper.selectByPrimaryKey(userFile.getFileId());
    }
}
