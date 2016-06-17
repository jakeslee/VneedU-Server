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

package asia.gkc.vneedu.utils;

import java.util.regex.Pattern;

/**
 * File Name: ValidationUtil.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/5/16 1:47 PM
 */

public class ValidationUtil {
    private static final Pattern mobilePattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");

    /**
     * 判断是否是手机号
     * @param phone 用于验证的手机号码
     * @return
     */
    public static boolean isPhoneNumber(String phone) {
        return phone != null && mobilePattern.matcher(phone).matches();
    }
}
