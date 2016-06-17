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

import asia.gkc.vneedu.model.RequirementFile;

/**
 * File Name: RequirementFileService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/8/16 10:34 AM
 */

public interface RequirementFileService extends IService<RequirementFile> {
    /**
     * 增加需求文件
     *
     * @param userFileId - 用户文件ID
     * @param requirementId - 需求ID
     * @return 需求模型
     */
    RequirementFile addFile(String userFileId, String requirementId);

    /**
     * 批量增加需求文件
     *
     * @param userFileIds   - 多个用户文件ID
     * @param requirementId - 需求ID
     * @return 增加的文件个数
     */
    int addFile(String[] userFileIds, String requirementId);
}
