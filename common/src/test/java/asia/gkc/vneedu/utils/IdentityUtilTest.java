package asia.gkc.vneedu.utils;

import io.jsonwebtoken.ExpiredJwtException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by jakes on 4/5/16.
 */
public class IdentityUtilTest extends BaseTest {
    @Test
    public void generate_hash() throws Exception {
        String hash = IdentityUtil.generate_hash("test");

        assertNotNull(hash);
    }

    @Test
    public void verify_password() throws Exception {
        String plain_text = "test string";

        String hash = IdentityUtil.generate_hash(plain_text);

        assertTrue(IdentityUtil.verify_password(hash, plain_text));
    }

    @Test
    public void verifyToken() throws Exception {
        String token = IdentityUtil.generateToken("hello");
        log.info(token);

        String ret = IdentityUtil.verifyToken(token);
        log.info(ret);

        assertEquals(ret, "hello");
    }

    @Test(expected = ExpiredJwtException.class)
    public void expired_token() throws Exception {
        String token = IdentityUtil.generateTokenExpireIn("hello", 10);

        IdentityUtil.verifyToken(token);
    }

    @Test
    public void generateToken() throws Exception {
        assertNotNull(IdentityUtil.generateToken("hello"));
    }
}