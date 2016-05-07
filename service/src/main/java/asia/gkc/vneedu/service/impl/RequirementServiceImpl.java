package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.common.QueryCondition;
import asia.gkc.vneedu.model.*;
import asia.gkc.vneedu.service.RequirementFileService;
import asia.gkc.vneedu.service.RequirementService;
import asia.gkc.vneedu.utils.BeanUtil;
import asia.gkc.vneedu.utils.FilterUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

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

    /**
     * 获取分类最新需求列表
     * 默认每页10条
     *
     * @param category - 分类
     *                 latest表示所有分类
     * @param page     - 页码
     * @return 需求列表
     */
    @Override
    public List<Requirement> getLatestRequirements(String category, int page) {
        return getLatestRequirements(category, page, 10);
    }

    /**
     * 获取分类最新需求列表
     *
     * @param category - 分类
     *                 latest表示所有分类
     * @param page     - 页码
     * @param limit    -  每页条数
     * @return 需求列表
     */
    @Override
    public List<Requirement> getLatestRequirements(String category, int page, int limit) {
        Example example = new Example(Requirement.class);
        Example.Criteria criteria = example.createCriteria();

        if (!category.equals("latest")) {
            String categoryId = categoryMapper.getCategoryByType(category).getId();
            criteria.andEqualTo("categoryId", categoryId);
        }
        example.orderBy("datetime").desc();

        PageHelper.startPage(page, limit);

        return requirementMapper.selectByExample(example);
    }


    /**
     * 查询处理
     *
     * @param list           - 用于处理的数据
     * @param queryCondition - 处理操作
     * @return 处理后的内容
     */
    @Override
    public List<Map<String, Object>> queryProcess(
            List<Requirement> list,
            QueryCondition queryCondition) {

        List<Map<String, Object>> result = new ArrayList<>();

        for (Requirement item: list) {
            Map<String, Object> map = BeanUtil.beanToMap(item, Requirement.class);

            Example imagesExample = new Example(RequirementFile.class);
            imagesExample.createCriteria().andEqualTo("requirementId", item.getId());
            for (String expand: queryCondition.getExpand()) {
                switch (expand) {
                    case "images":
                        List<RequirementFile> requirementFiles =  requirementFileMapper.selectByExample(imagesExample);
                        map.put("images", requirementFiles);
                        break;
                    case "publisher":
                        User user = userMapper.selectByPrimaryKey(item.getPublisherId());
                        map.put("publisher", user);
                        break;
                    case "category":
                        Category category = categoryMapper.selectByPrimaryKey(item.getCategoryId());
                        map.put("category", category);
                        break;
                }
            }
            map = FilterUtil.exclude(Arrays.asList(queryCondition.getExclude()), map);
            result.add(map);
        }
        return result;
    }
}
