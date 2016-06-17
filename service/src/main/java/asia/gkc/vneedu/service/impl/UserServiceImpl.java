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
        return userMapper.selectByPhone(phone) != null;
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

    /**
     * 判断AtID是否已经存在
     *
     * @param atId - 查询的AtId
     * @return 结果
     */
    @Override
    public boolean checkExistenceOfAtId(String atId) {
        return userMapper.selectByAtId(atId) != null;
    }
}
