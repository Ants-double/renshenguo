package com.antsdouble.ginseng.md5.util;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author lyy08
 */
public class CommonsCreate {

    public static  String createMd5(String input){
        // Pass input text to md5Hex() method
        String md5 = DigestUtils.md5Hex( input );
        return md5;
    }
}
