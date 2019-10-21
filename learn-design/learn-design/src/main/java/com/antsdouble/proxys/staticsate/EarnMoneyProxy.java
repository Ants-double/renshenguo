package com.antsdouble.proxys.staticsate;

/**
 * @ClassName EarnMoneyProxy
 * @Description 挣钱代理类
 * @date 4/2/2019
 * @Author liyy
 * @Version 1.0
 */
public class EarnMoneyProxy implements EarnMoneyInterface {

    private  EarnMoneyInterface earnMoneyInterface =new EarnMoneyImpl();
    public void changeMoneyWithLife() {
        System.out.println("用命换钱之前先保证有命，能换");
        earnMoneyInterface.changeMoneyWithLife();
        System.out.println("换到的钱，要保证有命花");
    }
}
