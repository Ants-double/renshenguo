package com.antsdouble.steel.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyy
 * @description
 * @date 2019/9/17
 */
public class MinDeletionSize {

    public static void main(String[] args) {
        System.out.println("minDeletionSize");
        String[] testArray = new String[]{"cba", "daf", "ghi"};
        solution(testArray);
    }

    //第一版

    public static int solution(String[] A) {
        int result = 0;
        List<List<Character>> listChar = new ArrayList<>(100);
        if (A.length < 0) {
            return result;
        }

        for (int num = 0; num < A[0].length(); num++) {
            List<Character> temp = new ArrayList<>(1000);
            for (int j = 0; j < A.length; j++) {
                temp.add(A[j].charAt(num));
            }
            listChar.add(temp);
        }

        for (List<Character> item : listChar) {
            for (int i = 0; i < item.size() - 1; i++) {
                if (item.get(i) > item.get(i + 1)) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }

    /***
     * 功能描述 //第二版
     * @author lyy
     * @date 2019/9/17
     * @param [A]
     * @return int
     */
    public static int solution2(String[] A) {
        int result = 0;
        for (int num = 0; num < A[0].length(); num++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(num) > A[j + 1].charAt(num)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
