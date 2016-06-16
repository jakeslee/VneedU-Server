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

import io.jsonwebtoken.ExpiredJwtException;
import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * Created by jakes on 4/5/16.
 */
public class IdentityUtilTest {
    private Log logger = LogFactory.getLog(this.getClass());

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
        logger.info(token);

        String ret = IdentityUtil.verifyToken(token);
        logger.info(ret);

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