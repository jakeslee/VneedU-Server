package asia.gkc.vneedu.test;

import asia.gkc.vneedu.model.Category;
import asia.gkc.vneedu.utils.DataTest;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * File Name: FastJsonTest.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/2/16 5:51 PM
 */

public class FastJsonTest extends DataTest {
    @Test
    public void testConvert() {
        Category category = new Category();
        category.setName("Name");
        category.setIcon("Icon");
        category.setType("Type");
        category.setId(UUID.randomUUID().toString().replace("-", ""));
        String string = JSON.toJSONString(category);
        logger.info(string);
        Category category1 = JSON.parseObject(string, Category.class);

        assertEquals(category.getId(), category1.getId());
        assertEquals(category.getType(), category1.getType());
    }
}
