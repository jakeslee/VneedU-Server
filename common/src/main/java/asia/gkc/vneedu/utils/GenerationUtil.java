package asia.gkc.vneedu.utils;

import java.util.UUID;

/**
 * File Name: GenerationUtil.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/3/16 7:11 PM
 */

public class GenerationUtil {

    /**
     * 主键生成
     *
     * @return UUID - 生成的主键UUID
     */
    public static String generatePrimaryID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
