package com.antsdouble.bridges;

import org.junit.Test;

/**
 * @ClassName BridgeTest
 * @Description test
 * @date 4/4/2019
 * @Author liyy
 * @Version 1.0
 */
public class BridgeTest {

    @Test
    public void bridgeTest(){
        //正常发
        PayOffInterface payNormal=new PayOffOne();
        SalaryAbstract salary=new NormalSalary(payNormal);
        salary.sendSalary();
        //经常是下面这种情况哈哈
        PayOffInterface payDelay=new PayOffThree();
        SalaryAbstract delay=new DelaySalary(payDelay);
        delay.sendSalary();
    }
}
