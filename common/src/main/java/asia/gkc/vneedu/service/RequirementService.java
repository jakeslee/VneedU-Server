package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.Requirement;

import java.util.List;

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
     * @param userFiles - 用户文件ID
     * @return 创建的需求
     */
    Requirement addRequirementWithFiles(Requirement requirement, String[] userFiles);

    /**
     * 增加需求
     *
     * @param requirement - 需求模型
     * @param userFiles - 用户文件ID
     * @param category - 分类值
     * @return 创建的需求
     */
    Requirement addRequirementWithFiles(Requirement requirement, String[] userFiles, String category);

    /**
     * 获取分类最新需求列表
     * 默认每页10条
     *
     * @param category - 分类
     *                 latest表示所有分类
     * @param page - 页码
     * @return 需求列表
     */
    List<Requirement> getLatestRequirements(String category, int page);

    /**
     * 获取分类最新需求列表
     *
     * @param category - 分类
     *                 latest表示所有分类
     * @param page - 页码
     * @param limit -  每页条数
     * @return 需求列表
     */
    List<Requirement> getLatestRequirements(String category, int page, int limit);
}
