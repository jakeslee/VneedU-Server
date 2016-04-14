package asia.gkc.vneedu;

import asia.gkc.vneedu.model.Category;
import asia.gkc.vneedu.service.CategoryService;
import asia.gkc.vneedu.utils.DataTest;
import com.qiniu.util.StringMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;

/**
 * File Name: InitializeDB.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 4/14/16 2:17 PM
 */

public class InitializeDB extends DataTest {
    @Autowired
    private CategoryService categoryService;

    private void initCategory(StringMap stringMap) {
        Category category = new Category();
        category.setName((String) stringMap.get("name"));
        category.setIcon((String) stringMap.get("icon"));
        category.setType((String) stringMap.get("type"));
        categoryService.addObject(category);
    }

    @Test
    @Rollback(value = false)
    public void initDB() throws Exception {
        /**
         * 生成Category分类信息
         *
         * 分类列表
         * ----------
         * 分类名      |   分类标识      |   分类图标
         * ------------------------------------------------------------
         * 施工        |   build         |   static/img/under-construction.png
         * 家教        |   edu           |   static/img/family-edu.png
         * 钟点工       |  part-time     |   static/img/part-time-job.png
         * 代驾        |   driving       |   static/img/driving.png
         * 代购        |   buying        |   static/img/buying.png
         * 送药上门     |   medicine      |   static/img/medicine.png
         * 送礼        |   gift          |   static/img/gift.png
         * 代班        |   working       |   static/img/working.png
         * ------------------------------------------------------------
         */
        List<StringMap> stringMaps = Arrays.asList(
                new StringMap().put("name", "施工")
                        .put("type", "build")
                        .put("icon", "static/img/under-construction.png"),
                new StringMap().put("name", "家教")
                        .put("type", "edu")
                        .put("icon", "static/img/family-edu.png"),
                new StringMap().put("name", "钟点工")
                        .put("type", "part-time")
                        .put("icon", "static/img/part-time-job.png"),
                new StringMap().put("name", "代驾")
                        .put("type", "driving")
                        .put("icon", "static/img/driving.png"),
                new StringMap().put("name", "代购")
                        .put("type", "buying")
                        .put("icon", "static/img/buying.png"),
                new StringMap().put("name", "送药上门")
                        .put("type", "medicine")
                        .put("icon", "static/img/medicine.png"),
                new StringMap().put("name", "送礼")
                        .put("type", "gift")
                        .put("icon", "static/img/gift.png"),
                new StringMap().put("name", "代班")
                        .put("type", "working")
                        .put("icon", "static/img/working.png")
        );
        for (StringMap s :
                stringMaps) {
            initCategory(s);
        }
    }
}
