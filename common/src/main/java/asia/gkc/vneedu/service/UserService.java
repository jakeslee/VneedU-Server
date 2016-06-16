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

    /**
     * 判断AtID是否已经存在
     *
     * @param atId - 查询的AtId
     * @return 结果
     */
    boolean checkExistenceOfAtId(String atId);
}
