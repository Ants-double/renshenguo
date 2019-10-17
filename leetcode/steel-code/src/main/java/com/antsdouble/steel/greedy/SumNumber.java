package com.antsdouble.steel.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class SumNumber {
    public int[] twoSum(int[] nums, int target) {
        for (int index = 0; index < nums.length; index++) {

            for (int i = index + 1; i < nums.length; i++) {
                if (nums[index] + nums[i] == target) {
                    return new int[]{index, i};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] TwoSumMap(int[] nums, int target) {

        // 第一次生成索引
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        //第二次进行判断
        for (int i = 0; i < nums.length; i++) {
            int complement=target-nums[i];
            if(map.containsKey(complement)&&map.get(complement)!=i){
                return  new int[]{i,map.get(complement)};
            }

        }
        throw new IllegalArgumentException("No two sum solution");


    }
}
