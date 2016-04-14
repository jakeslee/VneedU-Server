package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.Requirement;

/**
 * File Name: RequirementService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/8/16 10:32 AM
 */

public interface RequirementService extends IService<Requirement> {
    /**
     * 增加需求
     *
     * @param requirement - 需求模型
     * @param files - 用户文件ID
     * @return 创建的需求
     */
    Requirement addRequirementWithFiles(Requirement requirement, String[] userFiles);
}
