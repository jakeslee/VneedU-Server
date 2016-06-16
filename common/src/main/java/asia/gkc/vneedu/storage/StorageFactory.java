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

package asia.gkc.vneedu.storage;

import asia.gkc.vneedu.storage.impl.LocalStorageImpl;
import asia.gkc.vneedu.storage.impl.QiniuStorageImpl;
import asia.gkc.vneedu.utils.BeanUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * File Name: StorageFactory.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/9/16 5:48 PM
 */

public final class StorageFactory {

    /**
     * 获取远程存储服务
     * @param bucket
     * @return
     */
    public static Storage getStorage(String bucket) {
        if (bucket.equals("qiniu")) {
            return BeanUtil.getBean(QiniuStorageImpl.class);
        }
        // 默认使用本地存储
        return BeanUtil.getBean(LocalStorageImpl.class);
    }
}
