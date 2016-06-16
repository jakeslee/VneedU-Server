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

package asia.gkc.vneedu.common.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * File Name: LocalStorageProperties.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/9/16 5:53 PM
 */

@Component
public final class LocalStorageProperties {
    private final String name;
    private final String urlPath;
    private final String storeInDir;

    @Autowired
    public LocalStorageProperties(@Value("${app.storage.cdn.local.urlPath}") String urlPath,
                                  @Value("${app.storage.cdn.local.storeInDir}") String storeInDir,
                                  @Value("${app.storage.cdn.local.name}") String name) {
        this.name = name;
        this.urlPath = urlPath;
        this.storeInDir = storeInDir;

        File baseDir = new File(storeInDir);
        if (!baseDir.exists())
            baseDir.mkdirs();
    }

    public String getName() {
        return name;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public String getStoreInDir() {
        return storeInDir;
    }
}
