package asia.gkc.vneedu.authorization.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * File Name: RequireLogin.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/5/16 2:34 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireLogin {
}
