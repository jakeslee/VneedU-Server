package asia.gkc.vneedu.controller.api.v1_0;

import asia.gkc.vneedu.authorization.annotation.ActiveUser;
import asia.gkc.vneedu.authorization.annotation.RequireLogin;
import asia.gkc.vneedu.common.QueryCondition;
import asia.gkc.vneedu.common.ResultStatus;
import asia.gkc.vneedu.controller.core.BaseController;
import asia.gkc.vneedu.common.ResultModel;
import asia.gkc.vneedu.model.Judgement;
import asia.gkc.vneedu.model.Requirement;
import asia.gkc.vneedu.model.User;
import asia.gkc.vneedu.model.UserFile;
import asia.gkc.vneedu.utils.FilterUtil;
import asia.gkc.vneedu.utils.GenerationUtil;
import asia.gkc.vneedu.utils.IdentityUtil;
import asia.gkc.vneedu.utils.ValidationUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * File Name: UserController.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/5/16 12:02 PM
 */
@RestController
@RequestMapping(value = "/api/v1.0")
public class UserController extends BaseController {
    /**
     * 用户注册接口
     * @param user - 用户发送的注册信息
     * @return ResultModel
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResultModel register(@Valid User user, BindingResult errors) {
        // 校验错误
        if (errors.hasFieldErrors("phone"))
            return ResultModel.ERROR(ResultStatus.PHONE_REQUIRED);
        else if (errors.hasFieldErrors("passwordHash"))
            return ResultModel.ERROR(ResultStatus.PASSWORD_EMPTY);

        if (StringUtils.isEmpty(user.getName())) {
            LocalDateTime now = LocalDateTime.now();
            user.setName(String.format("user_%d%d%d%d%d", now.getMonthValue(), now.getDayOfMonth(),
                    now.getHour(), now.getMinute(), now.getSecond()));
        }

        logger.debug(user.getAtId());
        FilterUtil.exclude(Arrays.asList("at_id"), user);

        // 生成自定义at id
        String defaultAtId = user.getName().replace(" ", "");
        while (userService.checkExistenceOfAtId(defaultAtId)) {
            defaultAtId += GenerationUtil.randomInteger(11, 999);
        }
        user.setAtId(defaultAtId);

        logger.debug(user.getAtId());

        if (userService.checkExistenceOfPhone(user.getPhone())) {
            return ResultModel.ERROR(ResultStatus.PHONE_EXISTS);
        }

        userService.addObjectWithoutNull(user);
        logger.info("Add user: " + user.getId());

        String token = IdentityUtil.generateToken(user.getId());
        user.setToken(token);

        return ResultModel.SUCCESS("user", user);
    }

    /**
     * 修改当前用户
     * @param user - 修改的用户信息
     * @param currentUser - 当前用户注入
     * @return 操作结果
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @RequireLogin
    public ResultModel modify(User user, @ActiveUser User currentUser) {
        user.setId(currentUser.getId());

        // 去除不能通过本API修改的属性和未使用属性atId
        FilterUtil.exclude(Arrays.asList("passwordHash", "phone", "avatar", "atId"), user);

        logger.info(JSON.toJSONString(user));

        return userService.updateObjectWithoutNull(user) == 1 ?
                ResultModel.OK() : ResultModel.ERROR(ResultStatus.ERROR_IN_SAVING);
    }

    /**
     * 修改密码
     * @param password - 新的密码
     * @param currentUser - 当前用户注入
     * @return 操作结果
     */
    @RequestMapping(value = "/user/password", method = RequestMethod.PUT)
    @RequireLogin
    public ResultModel modify_password(String password, @ActiveUser User currentUser) {
        // 密码合法性校验
        if (StringUtils.isEmpty(password)) {
            return ResultModel.ERROR(ResultStatus.PASSWORD_EMPTY);
        } else if (password.length() < 5) {
            return ResultModel.ERROR(ResultStatus.PASSWORD_LENGTH_ERROR);
        }
        // 通过密码设置方法设置,不能直接设置密码存储字段
        currentUser.setPassword(password);

        userService.updateObjectWithoutNull(currentUser);
        return ResultModel.OK();
    }

    /**
     * 获取用户自己的信息
     * @param currentUser - 当前用户注入
     * @return 用户信息
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @RequireLogin
    public ResultModel getUserSelf(@ActiveUser User currentUser) {
        if (currentUser == null)
            return ResultModel.ERROR(ResultStatus.AUTHORIZATION_HEADER_ERROR);
        return ResultModel.SUCCESS("user", currentUser);
    }

    /**
     * 获取用户信息
     * @param uid - 用户的ID
     * @return 用户信息
     */
    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    @RequireLogin
    public ResultModel getUser(@PathVariable String uid) {
        User user = userService.getObjectById(uid);

        if (user == null) {
            return ResultModel.ERROR(ResultStatus.RESOURCE_NOT_FOUND);
        }

        FilterUtil.exclude(Arrays.asList("phone"), user);

        return ResultModel.SUCCESS("user", user);
    }

    /**
     * 用户登录接口
     * @param phone - 登录验证的手机号
     * @param password - 对应的密码
     * @return ResultModel
     */
    @RequestMapping(value = "/user/authorization", method = RequestMethod.POST)
    public ResultModel authorization(String phone, String password) {
        // 验证登录信息的合法性
        if (!ValidationUtil.isPhoneNumber(phone))
            return ResultModel.ERROR(ResultStatus.PHONE_ILLEGAL);
        else if (StringUtils.isEmpty(password))
            return ResultModel.ERROR(ResultStatus.PASSWORD_EMPTY);

        User user = userService.verifyPasswordOfUserByPhone(phone, password);
        if (user == null) {
            return ResultModel.ERROR(ResultStatus.AUTHORIZATION_PASSWORD_ERROR);
        }

        logger.info("Signed in: " + user.getId());

        String token = IdentityUtil.generateToken(user.getId());
        user.setToken(token);
        return ResultModel.SUCCESS("user", user);
    }

    @RequestMapping(value = "/user/avatar", method = RequestMethod.PUT)
    @RequireLogin
    public ResultModel changeAvatar(@RequestParam(value = "userfileId") String userFileId,
                                    @ActiveUser User user) {

        UserFile userFile = userFileService.getObjectById(userFileId);

        if (userFile == null)
            return ResultModel.ERROR(ResultStatus.FILE_ID_INCORRECT);

        user.setAvatar(userFile.getUrl());
        userService.updateObjectWithoutNull(user);

        return ResultModel.OK();
    }

    @RequestMapping(value = "/user/judgements/{uid}", method = RequestMethod.GET)
    @RequireLogin
    public ResultModel judgements(@PathVariable(value = "uid") String uid) {
        User user = userService.getObjectById(uid);

        if (user == null)
            return ResultModel.ERROR(ResultStatus.RESOURCE_NOT_FOUND);

        List<Judgement> judgements = judgementService.getJudgementsByUid(uid);

        List<Map<String, Object>> rets = judgementService.queryProcess(judgements,
                new QueryCondition("requirementId, userId", "mask_name, avatar"));

        return ResultModel.SUCCESS("judgements", rets);
    }

    @RequestMapping(value = "/user/requirements/{uid}", method = RequestMethod.GET)
    @RequireLogin
    public ResultModel requirements(@PathVariable(value = "uid") String uid) {
        User user = userService.getObjectById(uid);

        if (user == null)
            return ResultModel.ERROR(ResultStatus.RESOURCE_NOT_FOUND);

        List<Requirement> requirements = requirementService.getRequirementsByUid(uid);

        return ResultModel.SUCCESS("requirements",
                requirementService.queryProcess(requirements,
                        new QueryCondition("", "publisher, comments, category")));
    }
}
