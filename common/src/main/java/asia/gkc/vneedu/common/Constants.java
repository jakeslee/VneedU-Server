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

package asia.gkc.vneedu.common;

import org.springframework.stereotype.Component;

/**
 * File Name: Constants.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/5/16 3:50 PM
 */

@Component
public class Constants {
    /**
     * 用户ID名定义
     */
    public static final String USER_ID_IN_REQUEST = "UUID";

    /**
     * 授权信息存放的请求头
     */
    public static final String AUTHORIZATION = "authorization";

    /**
     * TOKEN有效期三十天, ms
     */
    public static final long TOKEN_EXPIRE = 1000L * 60 * 60 * 24 * 30;

    /**
     * 加密密钥
     */
    public static final String SECRET_STRING = "fiyg756sv*(^D[Vison]v73rb9vuh[Success]gkj0946u";
}
