package asia.gkc.vneedu.common.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * File Name: CdnProperties.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/9/16 11:11 AM
 */

@Component
public final class CdnProperties {
    private final boolean cdnEnabled;
    private final String bucket;
    private final QiniuProperties qiniuProperties;
    private final LocalStorageProperties localStorageProperties;

    @Autowired
    public CdnProperties(@Value("${app.storage.cdn.enabled:false}") boolean cdnEnabled,
                         @Value("${app.storage.cdn.bucket}") String bucket,
                         QiniuProperties qiniuProperties,
                         LocalStorageProperties localStorageProperties) {
        this.cdnEnabled = cdnEnabled;
        this.bucket = bucket;
        this.qiniuProperties = qiniuProperties;
        this.localStorageProperties = localStorageProperties;
    }

    public boolean isCdnEnabled() {
        return cdnEnabled;
    }

    public String getBucket() {
        return bucket;
    }

    public QiniuProperties getQiniuProperties() {
        return qiniuProperties;
    }

    public LocalStorageProperties getLocalStorageProperties() {
        return localStorageProperties;
    }
}
