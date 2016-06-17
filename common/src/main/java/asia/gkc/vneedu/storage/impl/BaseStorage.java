/*
 * Copyright 2016 Jakes Lee
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
