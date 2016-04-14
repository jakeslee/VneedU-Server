package asia.gkc.vneedu.controller.api.v1_0;

import asia.gkc.vneedu.authorization.annotation.ActiveUser;
import asia.gkc.vneedu.authorization.annotation.RequireLogin;
import asia.gkc.vneedu.common.ResultModel;
import asia.gkc.vneedu.common.ResultStatus;
import asia.gkc.vneedu.controller.core.BaseController;
import asia.gkc.vneedu.model.Requirement;
import asia.gkc.vneedu.model.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * File Name: RequirementController.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 4/12/16 11:27 AM
 */

@RestController
@RequestMapping(value = "/api/v1.0")
public class RequirementController extends BaseController {

    @RequestMapping(value = "/requirement", method = RequestMethod.POST)
    @RequireLogin
    public ResultModel newRequirement(@Valid Requirement requirement,
                                      @RequestParam(value = "images", required = false) String images,
                                      @ActiveUser User currentUser,
                                      BindingResult errors) {

        if (errors.hasFieldErrors("price"))
            return ResultModel.ERROR(ResultStatus.INCORRECT_PRICE);
        else if (errors.hasFieldErrors("payMethod"))
            return ResultModel.ERROR(ResultStatus.INCORRECT_PAY_METHOD);

        // 设置发布用户为当前用户
        requirement.setPublisherId(currentUser.getId());

        logger.debug(images);

        String[] files = null;
        if (images != null) {
            JSONArray jsonArray = JSON.parseArray(images);
            files = jsonArray.toArray(new String[0]) ;
        }

        requirementService.addRequirementWithFiles(requirement, files);

        if (requirement.getId() == null)
            return ResultModel.ERROR(ResultStatus.ERROR_IN_SAVING);
        return ResultModel.OK();
    }
}
