package asia.gkc.vneedu.storage;

import java.io.File;

/**
 * File Name: Storage.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/9/16 10:59 AM
 */

public interface Storage {
    /**
     * 上传文件
     *
     * @param file - 指定的文件
     * @param key - 文件在服务器存储
     * @return 上传的文件的哈希值
     */
    String uploadFile(File file, String key);

    /**
     * 删除指定的文件
     *
     * @param key - 指定文件的Key
     */
    void deleteFile(String key);

    /**
     * 获取文件上传的Token
     *
     *  本方法一般用于客户端直接上传文件到云存储
     *
     * @return 获取到的Token
     */
    String getUploadToken();

    /**
     * 获取文件上传的服务器
     *
     * @return 服务器地址
     */
    String getUploadServer();
}
