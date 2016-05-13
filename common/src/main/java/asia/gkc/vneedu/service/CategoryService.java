package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.Category;

/**
 * File Name: CategoryService.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/1/16 4:28 PM
 */

public interface CategoryService extends IService<Category> {
    /**
     * 通过分类值获取分类
     *
     * @param type 分类值
     * @return 分类
     */
    Category getCategoryByType(String type);
}
