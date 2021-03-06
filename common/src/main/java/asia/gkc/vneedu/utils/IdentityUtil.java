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

import asia.gkc.vneedu.common.Constants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;

/**
 * File Name: IdentityUtil.java
 * Function: 
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/5/16 11:42 AM
 */

public class IdentityUtil {
    /**
     * 生成密码哈希（加盐）
     * @param pain_text
     * @return
     */
    public static String generate_hash(String pain_text) {
        return BCrypt.hashpw(pain_text, BCrypt.gensalt());
    }

    /**
     * 验证哈希密码是否正确
     * @param hash
     * @param pain_text
     * @return
     */
    public static boolean verify_password(String hash, String pain_text) {
        return BCrypt.checkpw(pain_text,hash);
    }

    /**
     * Token验证
     * @param token - 令牌
     * @return
     */
    public static String verifyToken(String token) throws Exception {
        return Jwts.parser().requireSubject("sign").requireIssuer("asia.gkc.vneedu")
                .setSigningKey(Constants.SECRET_STRING).parseClaimsJws(token)
                .getBody().get("uid").toString();
    }

    /**
     * 生成Token
     */
    public static String generateToken(String uid) {
        return generateTokenExpireIn(uid, Constants.TOKEN_EXPIRE);
    }

    /**
     * 生成指定期限的Token
     */
    public static String generateTokenExpireIn(String uid, long expiration) {
        return Jwts.builder()
                .setSubject("sign").setIssuer("asia.gkc.vneedu").claim("uid", uid)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, Constants.SECRET_STRING)
                .compact();
    }
}
