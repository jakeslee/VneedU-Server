package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.model.Category;
import asia.gkc.vneedu.model.Requirement;
import asia.gkc.vneedu.repository.CategoryMapper;
import asia.gkc.vneedu.repository.RequirementMapper;
import asia.gkc.vneedu.service.RequirementFileService;
import asia.gkc.vneedu.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * File Name: RequirementServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 4/12/16 10:13 AM
 */

@Service
public class RequirementServiceImpl extends BaseService<Requirement> implements RequirementService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RequirementMapper requirementMapper;

    @Autowired
    private RequirementFileService requirementFileService;

    /**
     * 增加需求
     *
     * @param requirement - 需求模型
     * @param userFiles   - 用户文件ID
     * @return 创建的需求
     */
    @Override
    public Requirement addRequirementWithFiles(Requirement requirement, String[] userFiles) {
        return addRequirementWithFiles(requirement, userFiles, null);
    }

    /**
     * 增加需求
     *
     * @param requirement - 需求模型
     * @param userFiles - 用户文件ID
     * @param category - 分类值
     * @return 创建的需求
     */
    @Override
    public Requirement addRequirementWithFiles(
            Requirement requirement, String[] userFiles, String category) {

        if (category == null) {
            if (categoryMapper.selectByPrimaryKey(requirement.getCategoryId()) == null)
                return null;
        } else {
            Category categoryObj = categoryMapper.getCategoryByType(category);
            if (categoryObj == null)
                return null;
            // 设置分类ID
            requirement.setCategoryId(categoryObj.getId());
        }

        // 设置当前时间
        requirement.setDatetime(new Date());

        requirementMapper.insertSelective(requirement);
        if (requirement.getId() == null)
            return null;

        if (userFiles != null)
            requirementFileService.addFile(userFiles, requirement.getId());

        return requirement;
    }
}
