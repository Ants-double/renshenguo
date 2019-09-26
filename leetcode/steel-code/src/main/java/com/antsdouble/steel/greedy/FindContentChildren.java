package com.antsdouble.steel.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyy
 * @description
 * @date 2019/9/26
 */
public class FindContentChildren {
    public static void main(String[] args) {
        System.out.println("455");
        System.out.println(solution(new int[]{1, 2, 3}, new int[]{1, 1}));
    }

    private static int solution(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int i = 0;
        for(;i < g.length && j < s.length;j++){
            if(g[i] <= s[j]){
                i++;
            }
        }
        result=i;
        return result;
    }
}
