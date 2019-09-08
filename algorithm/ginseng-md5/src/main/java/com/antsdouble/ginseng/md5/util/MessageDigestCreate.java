package com.antsdouble.ginseng.md5.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author lyy08
 */
public class MessageDigestCreate {
    private static Integer SALT_LENGTH = 16;
    private static Integer SALT_MD5_LENGTH = 48;
    private static Integer STEP_LENGTH = 3;

    public static String createMd5(String input) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] hashBytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String createMd5WithSalt(String input) throws NoSuchAlgorithmException {

        // 生成一个16位的随机数
        SecureRandom random = new SecureRandom();
        StringBuilder sBuilder = new StringBuilder(16);
        sBuilder.append(random.nextInt(66888888)).append(random.nextInt(66888888));
        int len = sBuilder.length();
        if (len < SALT_LENGTH) {
            for (int i = 0; i < SALT_LENGTH - len; i++) {
                sBuilder.append("0");
            }
        }
        // 生成最终的加密盐
        String Salt = sBuilder.toString();
        String saltMd5 = createMd5(input + Salt);
        char[] cs = new char[SALT_MD5_LENGTH];
        for (int i = 0; i < SALT_MD5_LENGTH; i += STEP_LENGTH) {
            cs[i] = saltMd5.charAt(i / 3 * 2);
            char c = Salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = saltMd5.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }

    public static boolean verifyMd5WithSalt(String input, String md5str) throws NoSuchAlgorithmException {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < SALT_MD5_LENGTH; i += STEP_LENGTH) {
            cs1[i / 3 * 2] = md5str.charAt(i);
            cs1[i / 3 * 2 + 1] = md5str.charAt(i + 2);
            cs2[i / 3] = md5str.charAt(i + 1);
        }
        String Salt = new String(cs2);
        return createMd5(input + Salt).equals(String.valueOf(cs1));
    }

}
