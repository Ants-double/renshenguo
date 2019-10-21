package com.antsdouble.bridges;

/**
 * @ClassName PayOffOne
 * @Description 一次性发
 * @date 4/4/2019
 * @Author liyy
 * @Version 1.0
 */
public class PayOffOne implements PayOffInterface {
    public void sendMoney() {
        System.out.println("一次性发放工资");
    }
}
