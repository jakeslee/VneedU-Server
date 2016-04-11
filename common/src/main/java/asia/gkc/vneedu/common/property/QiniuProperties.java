package asia.gkc.vneedu.common.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * File Name: QiniuProperties.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/9/16 11:05 AM
 */

@Component
public final class QiniuProperties {
    private final String accessKey;
    private final String secretKey;
    private final String[] urlPath;
    private final String bucketName;
    private final String callbackPath;
    private final String uploader;

    @Autowired
    public QiniuProperties(@Value("${app.storage.cdn.qiniu.urlPath}") String urlPath,
                           @Value("${app.storage.cdn.qiniu.name}")  String bucketName,
                           @Value("${app.storage.cdn.qiniu.uploader}") String uploader,
                           @Value("${app.storage.cdn.qiniu.ACCESS_KEY}") String accessKey,
                           @Value("${app.storage.cdn.qiniu.SECRET_KEY}") String secretKey,
                           @Value("${app.storage.cdn.qiniu.callback}") String callbackPath) {
        this.uploader = uploader;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucketName = bucketName;
        this.callbackPath = callbackPath;
        this.urlPath = urlPath.trim().split(",");
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String[] getUrlPath() {
        return urlPath;
    }

    public String getBucketName() {
        return bucketName;
    }

    public String getCallbackPath() {
        return callbackPath;
    }

    public String getUploader() {
        return uploader;
    }
}
