package asia.gkc.vneedu.storage.impl;

import asia.gkc.vneedu.common.property.CdnProperties;
import asia.gkc.vneedu.common.property.LocalStorageProperties;
import asia.gkc.vneedu.common.property.QiniuProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * File Name: BaseStorage.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/9/16 6:14 PM
 */

@Component
public abstract class BaseStorage {
    protected final Log logger = LogFactory.getLog(this.getClass());

    // 注入CDN配置信息
    @Autowired
    protected CdnProperties cdnProperties;

    // 注入本地存储配置信息
    @Autowired
    protected LocalStorageProperties localStorageProperties;

    // 注入七牛云存储配置信息
    @Autowired
    protected QiniuProperties qiniuProperties;
}
