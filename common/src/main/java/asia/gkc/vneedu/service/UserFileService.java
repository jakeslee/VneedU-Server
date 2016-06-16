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

package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.File;
import asia.gkc.vneedu.model.UserFile;

/**
 * File Name: UserFileService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/8/16 10:33 AM
 */

public interface UserFileService extends IService<UserFile> {
    /**
     * 获取文件模型
     *
     * @param id - 用户文件ID
     * @return 文件模型
     */
    File getFileByUserFileId(String id);
}
