package asia.gkc.vneedu.service.impl;

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
     * @param files - 用户文件ID
     * @return 创建的需求
     */
    @Override
    public Requirement addRequirementWithFiles(Requirement requirement, String[] userFiles) {
        if (categoryMapper.selectByPrimaryKey(requirement.getCategoryId()) == null)
            return null;

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
