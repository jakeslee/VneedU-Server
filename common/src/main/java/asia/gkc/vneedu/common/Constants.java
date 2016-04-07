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
     * TOKEN有效期, ms
     */
    public static final int TOKEN_EXPIRE = 1000 * 60 * 24 * 30;

    /**
     * 加密密钥
     */
    public static final String SECRET_STRING = "fiyg756sv*(^D[Vison]v73rb9vuh[Success]gkj0946u";
}
