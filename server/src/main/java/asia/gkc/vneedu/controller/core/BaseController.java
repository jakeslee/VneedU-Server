/*
 * Copyright 2016 Jakes Lee
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package asia.gkc.vneedu.controller.core;

import asia.gkc.vneedu.service.*;
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

    // Requirement Service
    @Autowired
    protected RequirementService requirementService;

    // Keyword Service
    @Autowired
    protected KeywordService keywordService;

    // Discussion Service
    @Autowired
    protected DiscussionService discussionService;

    // Order Service
    @Autowired
    protected OrderService orderService;

    // Judgement Service
    @Autowired
    protected JudgementService judgementService;
}
