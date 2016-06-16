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

package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.model.File;
import asia.gkc.vneedu.model.RequirementFile;
import asia.gkc.vneedu.model.UserFile;
import asia.gkc.vneedu.repository.FileMapper;
import asia.gkc.vneedu.repository.RequirementFileMapper;
import asia.gkc.vneedu.repository.UserFileMapper;
import asia.gkc.vneedu.service.RequirementFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File Name: RequirementFileServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/8/16 10:43 AM
 */

@Service
public class RequirementFileServiceImpl extends BaseService<RequirementFile> implements RequirementFileService {
    @Autowired
    private RequirementFileMapper requirementFileMapper;
    @Autowired
    private UserFileMapper userFileMapper;
    @Autowired
    private FileMapper fileMapper;

    /**
     * 增加需求文件
     *
     * @param userFileId - 用户文件ID
     * @param requirementId - 需求ID
     * @return 需求模型
     */
    @Override
    public RequirementFile addFile(String userFileId, String requirementId) {
        UserFile userFile = userFileMapper.selectByPrimaryKey(userFileId);
        if (userFile == null)
            return null;

        File file = fileMapper.selectByPrimaryKey(userFile.getFileId());

        RequirementFile requirementFile = new RequirementFile();
        requirementFile.setMime(file.getMime());
        requirementFile.setUserFileId(userFileId);
        requirementFile.setUrl(userFile.getUrl());
        requirementFile.setRequirementId(requirementId);

        requirementFileMapper.insertSelective(requirementFile);
        return requirementFile;
    }

    /**
     * 批量增加需求文件
     *
     * @param userFileIds   - 多个用户文件ID
     * @param requirementId - 需求ID
     * @return 增加的文件个数
     */
    @Override
    public int addFile(String[] userFileIds, String requirementId) {
        int count = 0;
        for (String userFile : userFileIds) {
            if (addFile(userFile, requirementId) != null)
                ++count;
        }
        return count;
    }
}
