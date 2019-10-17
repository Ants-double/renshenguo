package com.antsdouble.steel.greedy;

import java.util.Arrays;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class ThreeSumClosest {
    public static int Solution(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(res - target)) {
                    res = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }
            }

        }

        return res;
    }
}
