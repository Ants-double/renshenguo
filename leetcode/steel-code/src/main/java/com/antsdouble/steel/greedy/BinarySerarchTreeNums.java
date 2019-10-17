package com.antsdouble.steel.greedy;

/**
 * @author lyy
 * @Deprecated  树的个数 96
 * @date 2019/10/17
 */
public class BinarySerarchTreeNums {
    public int solution(int n) {
        return getResult(n);
    }

    private int getResult(int num) {
        int[] res = new int[num + 1];
        res[0] = 1;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += res[j - 1] * res[i - j];
            }
            res[i] = sum;
        }
        return res[num];
    }
    private int getResultHalf(int num) {
        int[] res = new int[num + 1];
        res[0] = 1;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            for (int j = 1; j <= i/2; j++) {
                sum += res[j - 1] * res[i - j];
            }
            res[i] = sum;
        }
        return res[num];
    }
}
