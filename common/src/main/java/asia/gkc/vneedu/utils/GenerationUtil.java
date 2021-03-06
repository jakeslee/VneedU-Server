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

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
     * 通过时间生成订单号
     *
     * @param date 时间
     * @return 订单号
     */
    public static String generateOrderNo(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(date) + GenerationUtil.randomInteger(10, 99);
    }

    /**
     * 生成用户文件路径
     */
    public static String generateUrlOfFile(String filename) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = simpleDateFormat.format(new Date());
        return String.format("/static/file%s/%s", dateStr, filename);
    }

    /**
     * 主键生成
     *
     * @return UUID - 生成的主键UUID
     */
    public static String generatePrimaryID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成文件SHA-1
     *
     * @param file - 文件
     * @return HASH值
     */
    public static String generateSha1ChecksumOfFile(InputStream inputStream) {
        //Use SHA-1 algorithm
        MessageDigest shaDigest;
        try {
            shaDigest = MessageDigest.getInstance("SHA-1");

            //SHA-1 checksum
            return getFileChecksum(shaDigest, inputStream);
        } catch (IOException e) {
            return null;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * 通过不同的摘要算法计算HASH
     *
     * @param digest - 摘要算法
     * @param fis - 处理的文件
     * @return HASH值
     * @throws IOException
     */
    private static String getFileChecksum(MessageDigest digest, InputStream fis) throws IOException {
        //Get file input stream for reading the file content
        //FileInputStream fis = new FileInputStream(file);

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        //Read file data and update in message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };

        //close the stream; We don't need it now.
        fis.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }

    /**
     * 生成随机整数
     *
     * @param min - 最小值
     * @param max - 最大值
     * @return 随机数
     */
    public static int randomInteger(int min, int max) {
        return  min + (int)(Math.random() * ((max - min) + 1));
    }
}
