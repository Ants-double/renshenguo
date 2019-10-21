package com.antsdouble.bridges;

/**
 * @ClassName PayOffTwo
 * @Description 工资分两次发
 * @date 4/4/2019
 * @Author liyy
 * @Version 1.0
 */
public class PayOffTwo implements PayOffInterface {
    public void sendMoney() {
        System.out.println("工资分两次发");
    }
}
