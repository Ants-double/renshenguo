package com.antsdouble.bridges;

/**
 * @ClassName PayOffThree
 * @Description 工资分三次发
 * @date 4/4/2019
 * @Author liyy
 * @Version 1.0
 */
public class PayOffThree implements PayOffInterface {
    public void sendMoney() {
        System.out.println("工资分三次发");
    }
}
