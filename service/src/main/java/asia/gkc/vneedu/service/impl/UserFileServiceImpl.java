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
import asia.gkc.vneedu.model.UserFile;
import asia.gkc.vneedu.repository.FileMapper;
import asia.gkc.vneedu.repository.UserFileMapper;
import asia.gkc.vneedu.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File Name: UserFileServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/8/16 10:41 AM
 */

@Service
public class UserFileServiceImpl extends BaseService<UserFile> implements UserFileService {
    @Autowired
    private UserFileMapper userFileMapper;
    @Autowired
    private FileMapper fileMapper;

    /**
     * 获取文件模型
     *
     * @param id - 用户文件ID
     * @return 文件模型
     */
    @Override
    public File getFileByUserFileId(String id) {
        UserFile userFile = userFileMapper.selectByPrimaryKey(id);

        return fileMapper.selectByPrimaryKey(userFile.getFileId());
    }
}
