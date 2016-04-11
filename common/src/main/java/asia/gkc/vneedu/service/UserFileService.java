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
