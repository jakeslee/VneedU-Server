package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.model.Category;
import asia.gkc.vneedu.repository.CategoryMapper;
import asia.gkc.vneedu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: CategoryServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 3/29/16 6:15 PM
 */
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    @Transactional
    public void addCategory(Category category) {
        categoryMapper.insert(category);
    }
}
