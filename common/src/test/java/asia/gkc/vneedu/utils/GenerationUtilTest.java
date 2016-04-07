package asia.gkc.vneedu.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jakes on 4/7/16.
 */
public class GenerationUtilTest {
    @Test
    public void generatePrimaryID() throws Exception {
        String uuid = GenerationUtil.generatePrimaryID();

        assertTrue(uuid.length() > 0);

        assertTrue(uuid.indexOf('-') == -1);
    }

}