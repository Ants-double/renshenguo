package com.antsdouble.chapter21;

import org.junit.Test;

import javax.xml.bind.ValidationEvent;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadTest
 * @Description testThread
 * @date 4/10/2019
 * @Author liyy
 * @Version 1.0
 */
public class ThreadTest {

    @Test
    public  void  runableTest(){
        LiftOff launch=new LiftOff();
        launch.run();
    }


    @Test
    public void  threadTest() throws InterruptedException {
        CountDownLatch  latch=new CountDownLatch(5);
        for (int i=0;i<5;i++){
            Thread t=new Thread(new LiftOff(latch));
            t.start();
        }
        latch.await();
        System.out.println("Waiting for liftOff");
    }

    @Test
    public void executorTest() throws InterruptedException {
        CountDownLatch  latch=new CountDownLatch(5);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            exec.execute(new LiftOff(latch));
        }
        exec.shutdown();
        latch.await();
        System.out.println("ok");
    }

    @Test
    public void fixThreadTest() throws InterruptedException {
        CountDownLatch  latch=new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0;i<5;i++){
            executorService.execute(new LiftOff(latch));
        }
        executorService.shutdown();
        latch.await();
        System.out.println("ok");
    }

    @Test
    public void singleThreadTest() throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(5);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0;i<5;i++){
            executorService.execute(new LiftOff(latch));
        }
        executorService.shutdown();
        latch.await();
        System.out.println("ok");
    }

}
