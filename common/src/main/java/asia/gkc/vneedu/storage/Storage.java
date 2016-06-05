package asia.gkc.vneedu.storage;

import java.io.File;

/**
 * File Name: Storage.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 4/9/16 10:59 AM
 */

public interface Storage {
    /**
     * 上传文件
     *
     * @param file - 指定的文件
     * @param key - 文件在服务器存储
     * @return 上传的文件的key
     */
    String uploadFile(final File file, final String key);

    /**
     * 上传数据
     *
     * @param data - 数据内容
     * @param key - 存储名称
     * @param mimeType - 数据类型
     * @return 存储的key
     */
    String uploadFile(final byte[] data, final String key, final String mimeType);

    /**
     * 删除指定的文件
     *
     * @param key - 指定文件的Key
     */
    boolean deleteFile(String key);

    /**
     * 获取访问Uri
     *
     * @param key - 检索的key
     * @return URI of resource
     */
    String getUri(String key);

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
