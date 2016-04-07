package asia.gkc.vneedu.controller.api.v1_0;

import asia.gkc.vneedu.common.ResultStatus;
import asia.gkc.vneedu.controller.core.BaseController;
import asia.gkc.vneedu.common.ResultModel;
import asia.gkc.vneedu.model.User;
import asia.gkc.vneedu.utils.IdentityUtil;
import asia.gkc.vneedu.utils.ValidationUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResultModel register(@Valid User user) {

        log.debug(user.getPhone());
        log.debug(user.getId());

        return ResultModel.SUCCESS("哈?");
    }

    /**
     * 用户登录接口
     * @param phone - 登录验证的手机号
     * @param password - 对应的密码
     * @return
     */
    @RequestMapping(value = "/user/authorization", method = RequestMethod.POST)
    public ResultModel authorization(String phone, String password) {
        if (ValidationUtil.isPhoneNumber(phone) && !StringUtils.isEmpty(password)) {
            User user = userService.verifyPasswordOfUserByPhone(phone, password);
            if (user == null) {
                return ResultModel.ERROR(ResultStatus.AYTHORIZATION_PASSWORD_ERROR);
            }
            String token = IdentityUtil.generateToken(user.getId());
            user.setToken(token);
            return ResultModel.SUCCESS("user", user);
        }
        return ResultModel.ERROR(ResultStatus.PASSWORD_EMPTY);
    }
}
