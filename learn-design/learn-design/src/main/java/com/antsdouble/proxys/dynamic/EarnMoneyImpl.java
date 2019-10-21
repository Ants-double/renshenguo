package com.antsdouble.proxys.dynamic;

/**
 * @ClassName EarnMoneyImpl
 * @Description 动态代理demo实现类
 * @date 4/2/2019
 * @Author liyy
 * @Version 1.0
 */
public class EarnMoneyImpl implements EarnMoneyInterface {
    public void changeMoneyWithLife() {
        System.out.println("用钱换命--动态");
    }
}
