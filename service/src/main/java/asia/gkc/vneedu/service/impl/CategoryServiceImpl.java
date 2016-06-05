package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.model.Category;
import asia.gkc.vneedu.service.CategoryService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * File Name: CategoryService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 3/29/16 6:15 PM
 */
@Service
public class CategoryServiceImpl
        extends BaseService<Category>
        implements CategoryService {
    /**
     * 通过分类值获取分类
     *
     * @param type 分类值
     * @return 分类
     */
    @Override
    public Category getCategoryByType(String type) {
        return categoryMapper.getCategoryByType(type);
    }
}
