package com.antsdouble.steel.greedy;

/**
 * @author lyy
 * @Deprecated  反转整数
 * @date 2019/10/17
 */
public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(-456));
    }

    public static int reverse(int x) {
        long a = 0;
        int b = 0;
        if (x >= 0) {
            b = (x + " ").length();
            System.out.println(b);
        } else {
            b = (x + " ").length() - 1;
        }

        while (x != 0) {
            for (int i = 0; i < b; i++) {
                int a1 = x % 10;
                x = (x - a1) / 10;
                a += (int) (a1 * Math.pow(10, b - i - 2));
            }
        }
        if ((a > Math.pow(2, 31) - 1) || (a < (-1 * Math.pow(2, 31)))) {
            return 0;
        }
        return (int) a;
    }

}
