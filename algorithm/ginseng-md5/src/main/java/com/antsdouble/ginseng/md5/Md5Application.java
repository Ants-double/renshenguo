package com.antsdouble.ginseng.md5;

import com.antsdouble.ginseng.md5.util.CommonsCreate;
import com.antsdouble.ginseng.md5.util.GuavaCreate;
import com.antsdouble.ginseng.md5.util.MessageDigestCreate;

import java.security.NoSuchAlgorithmException;

/**
 * @author lyy08
 */
public class Md5Application {
    public static void main(String[] args) {
        try {
            // 普通md5
            System.out.println(MessageDigestCreate.createMd5("测试md5"));
            System.out.println(GuavaCreate.createMd5("测试md5"));
            System.out.println(CommonsCreate.createMd5("测试md5"));
            // 加盐
            String md5WithSalt = MessageDigestCreate.createMd5WithSalt("测试md5");
            System.out.println(md5WithSalt);
            System.out.println(MessageDigestCreate.verifyMd5WithSalt("测试md5",md5WithSalt));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
