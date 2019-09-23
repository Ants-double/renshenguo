package com.antsdouble.steel.greedy;

/**
 * @author lyy
 * @description
 * @date 2019/9/23
 */
public class LemonadeChange {
    public static void main(String[] args) {

        System.out.println("860");
        System.out.println(solution(new int[]{5, 5, 5, 5, 10, 5, 10, 10, 10, 20}));
    }

    public static boolean solution(int[] bills) {
        boolean result = false;
        int flag5 = 0;
        int flag10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                flag5++;
                continue;
            } else if (bills[i] == 10) {
                if ((bills[i] - 5) / 5 <= flag5) {
                    flag5 -= (bills[i] - 5) / 5;
                } else {
                    flag5 = -1;
                    break;
                }
                flag10++;
            } else {
                int temp = bills[i];
                if (flag10 > 0) {
                    flag10--;
                    temp -= 10;
                }

                if ((temp - 5) / 5 <= flag5) {
                    flag5 -= (temp - 5) / 5;
                } else {
                    flag5 = -1;
                    break;
                }
            }
        }

        if (flag5 >= 0) {
            result = true;
        }
        return result;
    }
}
