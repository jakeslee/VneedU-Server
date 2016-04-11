package asia.gkc.vneedu.storage.impl;

import asia.gkc.vneedu.storage.Storage;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import asia.gkc.vneedu.utils.FileUtil;

/**
 * File Name: LocalStorageImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/9/16 6:07 PM
 */

@Component
public class LocalStorageImpl extends BaseStorage implements Storage {
    private File getFileByKey(String key) {
        return new File(FileUtil.join(localStorageProperties.getStoreInDir(), key));
    }

    /**
     * 上传文件
     *
     * @param file - 指定的文件
     * @param key  - 文件在服务器存储
     * @return 上传的文件的哈希值
     */
    @Override
    public String uploadFile(File file, String key) {
        String storeIn = FileUtil.join(localStorageProperties.getStoreInDir(), key);
        File destFile = new File(storeIn);

        try {
            if (FileUtil.transferFile(file, destFile))
                return storeIn;
        } catch (IOException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 删除指定的文件
     *
     * @param key - 指定文件的Key
     */
    @Override
    public void deleteFile(String key) {
        File file = getFileByKey(key);

        logger.info("Deleting: " + key);

        file.delete();
    }

    /**
     * 获取文件上传的Token
     * <p>
     * 本方法一般用于客户端直接上传文件到云存储
     *
     * @return 获取到的Token
     */
    @Override
    public String getUploadToken() {
        return null;
    }

    /**
     * 获取文件上传的服务器
     *
     * @return 服务器地址
     */
    @Override
    public String getUploadServer() {
        return null;
    }
}
