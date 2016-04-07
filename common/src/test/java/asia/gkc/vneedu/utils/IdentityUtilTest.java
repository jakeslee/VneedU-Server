package asia.gkc.vneedu.utils;

import io.jsonwebtoken.ExpiredJwtException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jakes on 4/5/16.
 */
public class IdentityUtilTest extends BaseTest {

    @Test
    public void verifyToken() throws Exception {
        String token = IdentityUtil.generateToken("hello");
        log.info(token);

        String ret = IdentityUtil.verifyToken(token);
        log.info(ret);

        Assert.assertEquals(ret, "hello");
    }

    @Test(expected = ExpiredJwtException.class)
    public void expired_token() throws Exception {
        String token = IdentityUtil.generateTokenExpireIn("hello", 10);

        IdentityUtil.verifyToken(token);
    }

    @Test
    public void generateToken() throws Exception {
        Assert.assertNotNull(IdentityUtil.generateToken("hello"));
    }
}