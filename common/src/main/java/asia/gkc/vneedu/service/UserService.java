package asia.gkc.vneedu.service;

import asia.gkc.vneedu.model.User;

/**
 * File Name: UserServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/1/16 4:28 PM
 */

public interface UserService extends IService<User> {
    /**
     * 通过手机号获取用户
     *
     * @param phone - 手机号
     * @return 结果
     */
    User getUserByPhone(String phone);

    /**
     * 判断手机是否已被注册
     *
     * @param phone - 判断的手机号码
     * @return 结果
     */
    boolean checkExistenceOfPhone(String phone);

    /**
     * 验证用户密码
     *
     * @param phone - 用户的手机
     * @param password - 用于验证的密码
     * @return 验证通过则返回用户信息,否则返回null
     */
    User verifyPasswordOfUserByPhone(String phone, String password);


}
