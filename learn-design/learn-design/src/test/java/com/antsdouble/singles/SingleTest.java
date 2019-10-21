package com.antsdouble.singles;

import org.junit.Test;

/**
 * @ClassName SingleTest
 * @Description 单例测试
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class SingleTest {

    @Test
    public  void  simpleSingleTest(){

        System.out.println(SimpleSingle.getInstance());
    }
}
