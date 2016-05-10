package asia.gkc.vneedu.controller.api.v1_0;

import asia.gkc.vneedu.authorization.annotation.ActiveUser;
import asia.gkc.vneedu.authorization.annotation.RequireLogin;
import asia.gkc.vneedu.common.QueryCondition;
import asia.gkc.vneedu.common.ResultModel;
import asia.gkc.vneedu.common.ResultStatus;
import asia.gkc.vneedu.controller.core.BaseController;
import asia.gkc.vneedu.model.Requirement;
import asia.gkc.vneedu.model.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.qiniu.util.StringMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

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
                                      @RequestParam(value = "category") String category,
                                      @RequestParam(value = "keywords", required = false) String keywords,
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
            if (jsonArray == null)
                return ResultModel.ERROR(ResultStatus.BAD_REQUEST);
            files = jsonArray.toArray(new String[0]) ;
        }

        requirementService.addRequirementWithFiles(requirement, files, category);

        if (!StringUtils.isEmpty(keywords)) {
            keywordService.addKeywordsToRequirement(keywords.split(","), requirement.getId());
        }

        if (requirement.getId() == null)
            return ResultModel.ERROR(ResultStatus.ERROR_IN_SAVING);
        return ResultModel.OK();
    }

    @RequestMapping(value = "/requirement/latest", method = RequestMethod.GET)
    public ResultModel latestRequirements(
            @RequestParam(value = "category", defaultValue = "latest") String category,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "exclude", defaultValue = "") String exclude,
            @RequestParam(value = "expand", defaultValue = "") String expand,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "withremoved", defaultValue = "0") int withRemoved,
            @RequestParam(value = "status", defaultValue = "0") int status) {

        List<Requirement> requirements = requirementService.getLatestRequirements(
                category, page, limit, withRemoved, status);

        PageInfo pageInfo = new PageInfo<>(requirements);

        return ResultModel.SUCCESS(new StringMap()
                .put("requirements",
                        requirementService.queryProcess(requirements, new QueryCondition(exclude, expand)))
                .put("page", new StringMap()
                            .put("page", page)
                            .put("limit", pageInfo.getSize())
                            .put("max_pages", pageInfo.getPages())
                            .put("size", pageInfo.getPageSize())
                        .map())
                .map());
    }

    @RequestMapping(value = "/requirement/{id}", method = RequestMethod.GET)
    public ResultModel getRequirement(@PathVariable("id") String reqId,
                                      @RequestParam(value = "exclude", defaultValue = "") String exclude,
                                      @RequestParam(value = "expand", defaultValue = "") String expand) {
        Requirement requirement = requirementService.getObjectById(reqId);

        if (requirement == null)
            return ResultModel.ERROR(ResultStatus.REQUIREMENT_NOT_EXIST);

        return ResultModel.SUCCESS(new StringMap()
                .put("requirement", requirementService.queryProcess(Arrays.asList(requirement),
                        new QueryCondition(exclude, expand)).get(0))
                .map());
    }

    @RequestMapping(value = "/requirement/discussions/{id}", method = RequestMethod.GET)
    public ResultModel getDiscussions(@PathVariable("id") String reqId,
                                      @RequestParam(value = "exclude", defaultValue = "") String exclude,
                                      @RequestParam(value = "expand", defaultValue = "") String expand) {
        Requirement requirement = requirementService.getObjectById(reqId);

        if (requirement == null)
            return ResultModel.ERROR(ResultStatus.REQUIREMENT_NOT_EXIST);

        return ResultModel.SUCCESS(new StringMap()
                .put("discussions", discussionService.getDiscussionsByReqId(reqId))
                /* 现在的讨论实现暂时是输出所有数据,并且不进行过滤了处理 */
                .put("page", new StringMap()
                        .put("page", 1)
                        .put("limit", 0)
                        .put("max_pages", 1)
                        .map())
                .map());
    }

}
