package com.antsdouble.steel.greedy;

/**
 * @author lyy
 * @Deprecated 现strStr()
 * @date 2019/10/17
 */
public class Haystack {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();
        if (needle.isEmpty()) {
            return 0;
        }

        int i = 0, j = 0;
        for (i = 0; i <= n - m; i++) {
            boolean flag = true;
            for (j = 0; j < m; j++) {

                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;

        }
        return -1;
    }

    public int strStrTwo(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n == 0) {
            return 0;
        }
        if (m > n) {
            return -1;
        }

        for (int i = 0; i < n - m; i++) {
            String subStr = haystack.substring(i, i + m);

            if (subStr.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
