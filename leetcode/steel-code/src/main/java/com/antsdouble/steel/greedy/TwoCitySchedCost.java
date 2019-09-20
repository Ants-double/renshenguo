package com.antsdouble.steel.greedy;

import java.util.*;

/**
 * @author lyy
 * @description
 * @date 2019/9/20
 */
public class TwoCitySchedCost {
    public static void main(String[] args) {
        System.out.println("1029");
        System.out.println(solution(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}));

    }

    public static int solution(int[][] costs) {

        int result = 0;
        int flag = 0;
        int flagB = 0;

        Map<Integer, Integer> mapB = new LinkedHashMap<>();

        Map<Integer, Integer> resultB = new LinkedHashMap<>();
        // 先求出城市数
        for (int i = 0; i < costs.length; i++) {
            mapB.put(i, Math.abs(costs[i][1] - costs[i][0]));
        }
        mapB.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).forEachOrdered(x -> resultB.put(x.getKey(), x.getValue()));
        // 取值

        for (Map.Entry<Integer,Integer> item:resultB.entrySet()){
            Integer i = item.getKey();
            if (costs[i][0] < costs[i][1]) {
                if (flag < costs.length / 2) {
                    result += costs[i][0];
                    flag++;
                    continue;
                }
                else {
                    result += costs[i][1];
                    flagB++;
                    continue;
                }
            } else {
                if (flagB < costs.length / 2) {
                    result += costs[i][1];
                    flagB++;
                    continue;
                }
                else {
                    result += costs[i][0];
                    flag++;
                    continue;
                }
            }
        }
        return result;
    }


}
