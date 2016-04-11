package asia.gkc.vneedu.storage.impl;

import asia.gkc.vneedu.storage.Storage;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * File Name: QiniuStorageImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 4/9/16 5:19 PM
 */

@Component
public class QiniuStorageImpl extends BaseStorage implements Storage {
    private Auth auth;
    private BucketManager bucketManager;
    private UploadManager uploadManager = new UploadManager();

    @PostConstruct
    public void init() {
        auth = Auth.create(qiniuProperties.getAccessKey(), qiniuProperties.getSecretKey());
        bucketManager = new BucketManager(auth);
    }

    /**
     * 上传文件
     *
     * @param file - 指定的文件
     * @param key  - 文件在服务器存储
     * @return 上传的文件的哈希值
     */
    @Override
    public String uploadFile(final File file, final String key) {
        try {
            Response response = uploadManager.put(file, key, auth.uploadToken(qiniuProperties.getBucketName()));

            if (response.isOK())
                return (String) response.jsonToMap().get("key");
        } catch (QiniuException e) {
            logger.warn(e.toString());
        }

        return null;
    }

    /**
     * 上传数据
     *
     * @param data     - 数据内容
     * @param key      - 存储名称
     * @param mimeType - 数据类型
     * @return 存储的哈希
     */
    @Override
    public String uploadFile(byte[] data, String key, String mimeType) {
        try {
            Response response = uploadManager.put(data, key, auth.uploadToken(qiniuProperties.getBucketName()),
                    null, mimeType, false);

            if (response.isOK())
                return (String) response.jsonToMap().get("key");
        } catch (QiniuException e) {
            logger.warn(e.toString());
        }

        return null;
    }

    /**
     * 删除指定的文件
     *
     * @param key - 指定文件的Key
     */
    @Override
    public boolean deleteFile(String key) {
        try {
            bucketManager.delete(qiniuProperties.getBucketName(), key);
            return true;
        } catch (QiniuException e) {
            logger.warn(e.toString());
        }
        return false;
    }

    /**
     * 获取访问Uri
     *
     * @param key - 检索的key
     * @return URI of resource
     */
    @Override
    public String getUri(String key) {
        return String.format("%s://%s", qiniuProperties.getProto(), key);
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
        return auth.uploadToken(qiniuProperties.getBucketName(), null, 3600, new StringMap()
                .put("callbackUrl", qiniuProperties.getCallbackPath())
                .put("callbackBody",
                        "filename=$(fname)&key=$(key)&hash=$(etag)&user=$(endUser)&mime=$(mimeType)"));
    }

    /**
     * 获取文件上传的服务器
     *
     * @return 服务器地址
     */
    @Override
    public String getUploadServer() {
        return qiniuProperties.getUploader();
    }
}
