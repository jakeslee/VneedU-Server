package asia.gkc.vneedu.authorization.annotation;

import java.lang.annotation.*;

/**
 * File Name: ActiveUser.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/5/16 3:48 PM
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ActiveUser {
}
