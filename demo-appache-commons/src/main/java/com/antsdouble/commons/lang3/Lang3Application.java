package com.antsdouble.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * @author lyy
 * @description
 * @date 2019/9/18
 */
public class Lang3Application {

    public static void main(String[] args) {
        System.out.println("This is apache commons");
        stringUtil();
    }

    public static void stringUtil() {

        // http://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html
        // 省略号标记字符串
        MyLogger.writeLogger(StringUtils.abbreviate("abcdefg", 6));
        // trim trimToNull trimToEmpty
        MyLogger.writeLogger(StringUtils.trim(null));
        MyLogger.writeLogger(StringUtils.trim("  "));
        MyLogger.writeLogger(StringUtils.trim("abc"));
        MyLogger.writeLogger(StringUtils.trim("    abc    "));
        MyLogger.writeLogger(StringUtils.trimToNull(null));
        MyLogger.writeLogger(StringUtils.trimToNull("    "));
        MyLogger.writeLogger(StringUtils.trimToEmpty(null));
        MyLogger.writeLogger(StringUtils.trimToEmpty("    "));
        // substring
        MyLogger.writeLogger(StringUtils.substring("abcdefg",3));
        MyLogger.writeLogger(StringUtils.substring("abcdefg",-2));
        MyLogger.writeLogger(StringUtils.substring("abcdefg",3,5));

        MyLogger.writeLogger(FastDateFormat.format);

    }


}
