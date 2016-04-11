package asia.gkc.vneedu.controller.core;

import asia.gkc.vneedu.service.CategoryService;
import asia.gkc.vneedu.service.FileService;
import asia.gkc.vneedu.service.UserFileService;
import asia.gkc.vneedu.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * File Name: BaseController.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/1/16 8:15 PM
 */

public abstract class BaseController {
    protected Log logger = LogFactory.getLog(this.getClass());

    /*
     * Servlet Injection
     * ------------------*/
    @Autowired
    protected HttpServletRequest request;

    /*
     * Service Injection
     * ------------------*/

    // User Service
    @Autowired
    protected UserService userService;

    // Category Service
    @Autowired
    protected CategoryService categoryService;

    // File Service
    @Autowired
    protected FileService fileService;

    // User File Service
    @Autowired
    protected UserFileService userFileService;
}
