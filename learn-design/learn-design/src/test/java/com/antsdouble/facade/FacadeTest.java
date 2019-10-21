package com.antsdouble.facade;

import org.junit.Test;

/**
 * @ClassName FacadeTest
 * @Description test
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class FacadeTest {

    @Test
    public void  faceTest(){
        Facade facade = new Facade();
        facade.money();

        //测试常量池
        String a="abc";
        String b="abc";
        System.out.println(a==b);
    }
}
