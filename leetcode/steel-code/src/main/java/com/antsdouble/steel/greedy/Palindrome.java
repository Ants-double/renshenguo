package com.antsdouble.steel.greedy;

/**
 * @author lyy
 * @Deprecated 回文数
 * @date 2019/10/17
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int mindleNumber = 0;
        while (x > mindleNumber) {
            mindleNumber = mindleNumber * 10 + x % 10;
            x /= 10;
        }
        return x == mindleNumber || x == mindleNumber / 10;
    }
}
