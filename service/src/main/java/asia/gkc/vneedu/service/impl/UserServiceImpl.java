package asia.gkc.vneedu.service.impl;

import asia.gkc.vneedu.model.User;
import asia.gkc.vneedu.repository.UserMapper;
import asia.gkc.vneedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * File Name: UserServiceImpl.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/1/16 4:32 PM
 */
@Service(value = "userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 判断手机是否已被注册
     *
     * @param phone - 判断的手机号码
     * @return 结果
     */
    @Override
    public boolean checkExistenceOfPhone(String phone) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("phone", phone);

        logger.debug(userMapper);

        return userMapper.selectCountByExample(example) != 0;
    }

    /**
     * 通过手机号获取用户
     *
     * @param phone - 手机号
     * @return 结果
     */
    @Override
    public User getUserByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    /**
     * 验证用户密码
     *
     * @param phone      - 用户的手机
     * @param password - 用于验证的密码
     * @return
     */
    @Override
    public User verifyPasswordOfUserByPhone(String phone, String password) {
        User user = userMapper.selectByPhone(phone);

        return user.verify_password(password) ? user : null;
    }
}
