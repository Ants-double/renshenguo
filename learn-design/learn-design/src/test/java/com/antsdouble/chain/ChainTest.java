package com.antsdouble.chain;

import org.junit.Test;

/**
 * @ClassName ChainTest
 * @Description test
 * @date 4/9/2019
 * @Author liyy
 * @Version 1.0
 */
public class ChainTest {

    @Test
    public void  chainTest(){

        ProjectHandler projectHandler=new ProjectHandler();
        DeptHandler deptHandler=new DeptHandler();
        GeneraHandler generaHandler=new GeneraHandler();
        projectHandler.setNextHandler(deptHandler);
        deptHandler.setNextHandler(generaHandler);
        projectHandler.handleRequest(0.3);
        System.out.println("-------------------");
        projectHandler.handleRequest(1.2);
        System.out.println("-------------------");
        projectHandler.handleRequest(4.5);
        System.out.println("-------------------");
        projectHandler.handleRequest(5.5);
        System.out.println("-------------------");



    }
}
