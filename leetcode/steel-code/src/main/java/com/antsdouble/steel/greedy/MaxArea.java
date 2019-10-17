package com.antsdouble.steel.greedy;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class MaxArea {
    public static int Solution(int[] height) {

        int res = Integer.MIN_VALUE;
        if (height.length < 2) return res;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                res = Math.max((j - i) * Math.min(height[i], height[j]), res);
            }
        }

        return res;
    }

    public  static  int SolutionTwo(int[] height){
        int res=Integer.MIN_VALUE;
        if (height.length<2) return res;
        int l=0,r=height.length-1;
        while (l<r){
            res=Math.max(res,Math.min(height[l],height[r])*(r-l));
            if (height[l]<height[r]){
                l++;
            }
            else {
                r--;
            }
        }
        return  res;

    }

    public static void main(String[] args) {
        System.out.println(SolutionTwo(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
