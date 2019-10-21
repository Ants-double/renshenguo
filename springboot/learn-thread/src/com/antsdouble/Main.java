package com.antsdouble;

import java.util.PrimitiveIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述
 * @author lyy
 * @date 2019/4/30
 * @param  * @param null
 * @return 
 */
public class Main {

    private static final int CIRCLE_NUM = 5;

    public static void main(String[] args) {

        // write your code here
        System.out.println("Hello Thread");
        //runnable
        LiftOff liftOff = new LiftOff(100);
        liftOff.run();
        //thread
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("thread waiting for liftoff!");
        //executor
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < CIRCLE_NUM; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
