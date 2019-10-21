package com.antsdouble.chapter21;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName LiftOff
 * @Description 2.1
 * @date 4/10/2019
 * @Author liyy
 * @Version 1.0
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    private CountDownLatch downLatch;
    public LiftOff() {
    }

    public LiftOff(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    public LiftOff(int countDown, CountDownLatch downLatch) {
        this.countDown = countDown;
        this.downLatch = downLatch;
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ").";
    }

    public void run() {

        while (countDown-- > 0) {
            System.out.println(status());
//            try {
//                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Thread.yield();
        }
        this.downLatch.countDown();
    }
}
