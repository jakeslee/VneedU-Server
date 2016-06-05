package asia.gkc.vneedu.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jakes on 4/6/16.
 */
public class ValidationUtilTest {
    private static final String validPhone = "13221061445";
    private static final String invalidPhoneWithShorter = "132210614";
    private static final String invalidPhoneWithBlankString = null;
    private static final String invalidPhoneWithNullString = null;

    @Test
    public void isPhoneNumber() throws Exception {
        assertTrue(ValidationUtil.isPhoneNumber(validPhone));

        assertFalse(ValidationUtil.isPhoneNumber(invalidPhoneWithShorter));

        assertFalse(ValidationUtil.isPhoneNumber(invalidPhoneWithBlankString));

        assertFalse(ValidationUtil.isPhoneNumber(invalidPhoneWithNullString));
    }
}