package asia.gkc.vneedu.storage.impl;

import asia.gkc.vneedu.storage.Storage;
import asia.gkc.vneedu.utils.GenerationUtil;
import org.springframework.stereotype.Component;

import java.io.*;
import asia.gkc.vneedu.utils.FileUtil;

/**
 * File Name: LocalStorageImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 4/9/16 6:07 PM
 */

@Component
public class LocalStorageImpl extends BaseStorage implements Storage {
    /**
     * 从Key获取文件
     *
     * @param key - 文件的Key
     * @return 文件
     */
    private File getFileByKey(String key) {
        return new File(FileUtil.join(localStorageProperties.getStoreInDir(), key));
    }

    /**
     * 上传文件
     *
     * @param file - 指定的文件
     * @param key  - 文件在服务器存储
     * @return 上传的文件的key
     */
    @Override
    public String uploadFile(File file, String key) {
        if (key == null) {
            try {
                key = GenerationUtil.generateSha1ChecksumOfFile(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                logger.warn(e.getMessage());
                return null;
            }
        }

        String storeIn = FileUtil.join(localStorageProperties.getStoreInDir(), key);
        if (!FileUtil.buildDir(storeIn))
            return null;

        File destFile = new File(storeIn);

        try {
            if (FileUtil.transferFile(file, destFile))
                return key;
        } catch (IOException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 上传数据
     *
     * @param data     - 数据内容
     * @param key      - 存储名称
     * @param mimeType - 数据类型
     * @return 存储的key
     */
    @Override
    public String uploadFile(byte[] data, String key, String mimeType) {
        return null;
    }

    /**
     * 删除指定的文件
     *
     * @param key - 指定文件的Key
     */
    @Override
    public boolean deleteFile(String key) {
        File file = getFileByKey(key);

        logger.info("Deleting: " + key);

        return file.delete();
    }

    /**
     * 获取访问Uri
     *
     * @param key - 检索的key
     * @return URI of resource
     */
    @Override
    public String getUri(String key) {
        return String.format("%s://%s", "local", key);
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
