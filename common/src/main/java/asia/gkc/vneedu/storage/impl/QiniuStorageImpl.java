package asia.gkc.vneedu.storage.impl;

import asia.gkc.vneedu.common.property.CdnProperties;
import asia.gkc.vneedu.storage.Storage;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String uploadFile(File file, @Nullable String key) {
        try {
            Response response = uploadManager.put(file, key, auth.uploadToken(qiniuProperties.getBucketName()));

            if (response.isOK())
                return (String) response.jsonToMap().get("hash");
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
    public void deleteFile(String key) {
        try {
            bucketManager.delete(qiniuProperties.getBucketName(), key);
        } catch (QiniuException e) {
            logger.warn(e.toString());
        }
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
