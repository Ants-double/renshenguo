package com.antsdouble.steel.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class LengthOfLongestSubstringSet {
    public int Solution(String s) {

//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            if (!set.contains(s.charAt(j))) {
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            } else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;


        //map
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
