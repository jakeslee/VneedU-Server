package asia.gkc.vneedu.controller;

import asia.gkc.vneedu.controller.core.BaseController;
import asia.gkc.vneedu.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * File Name: IndexController.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 3/28/16 8:17 PM
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
