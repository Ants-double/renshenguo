package com.antsdouble.states;

import org.junit.Test;

/**
 * @ClassName StateTest
 * @Description test state
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class StateTest {

    @Test
    public void  stateTest(){

       WorkContext workContext=new WorkContext();
       for (int i=-2;i<=1;i++){
           workContext.getWorkState(i);

       }

    }
}
