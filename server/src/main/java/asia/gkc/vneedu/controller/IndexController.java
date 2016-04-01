package asia.gkc.vneedu.controller;

import asia.gkc.vneedu.model.Category;
import asia.gkc.vneedu.repository.CategoryMapper;
import asia.gkc.vneedu.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 * File Name: IndexController.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 3/28/16 8:17 PM
 */
@Controller
public class IndexController {
    @Autowired
    CategoryService categoryService;

    Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping(value = "/index")
    public String index() {
        Category category = new Category();
        //System.out.println(UUID.randomUUID().toString());
        //category.setId(UUID.randomUUID().toString());
        category.setIcon("aaa");
        category.setName("aaa");
        category.setType("bbb");
        categoryService.addCategory(category);

        logger.debug(category.getId());

        return "index";
    }
}
