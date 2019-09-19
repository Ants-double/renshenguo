package com.antsdouble.steel.greedy;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author lyy
 * @description
 * @date 2019/9/18
 */
public class LastStoneWeight {
    public static void main(String[] args) {

        int[] test = new int[]{2,2,5,6,3,2,9,4};
        System.out.println(solution(test));
    }

    public static int solution(int[] stones) {
        int result = 0;
        if (stones==null){
            return result;
        }
        if (stones.length<2){
            return stones[0];
        }
        Arrays.sort(stones);
        do {
            if (stones[stones.length - 2] == stones[stones.length - 1]) {
                stones[stones.length - 2] = 0;
                stones[stones.length - 1] = 0;
            } else if (stones[stones.length - 2] < stones[stones.length - 1]) {
                stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
                stones[stones.length - 2] = 0;
            }
            Arrays.sort(stones);
        }
        while (stones[stones.length - 2] > 0);
        result = stones[stones.length - 1];
        return result;
    }
}
