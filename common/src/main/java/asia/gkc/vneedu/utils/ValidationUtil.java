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
