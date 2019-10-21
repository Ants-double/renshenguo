package com.antsdouble.decorator;

import org.junit.Test;

/**
 * @ClassName DecoratorTest
 * @Description test
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class DecoratorTest {

    @Test
    public void decoratorTest(){
        Boss boss=new MyBoss();
        DelayDecorator myBoss=new DelayDecorator(boss);
        myBoss.payOffSalary();
    }
}
