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
