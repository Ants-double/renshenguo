package com.antsdouble;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lyy
 * @description
 * @date 2019/4/30
 */
public class InterruptThread implements Runnable {

    private int num;

    public InterruptThread(int num) {
        this.num = num;
    }


    @Override
    public void run() {
        System.out.println("this is a thread" + num);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread interruptThread = new Thread(new InterruptThread(1));
        ScheduledFuture<?> scheduledFuture = ThreadPoolUtils.getInstance().getThreadPool().scheduleAtFixedRate(interruptThread, 0, 2, TimeUnit.SECONDS);

        InterruptThread interruptThread1 = new InterruptThread(2);
        ScheduledFuture<?> scheduledFuture1 = ThreadPoolUtils.getInstance().getThreadPool().scheduleAtFixedRate(interruptThread1, 0, 2, TimeUnit.SECONDS);

        InterruptThread interruptThread2 = new InterruptThread(3);
        ThreadPoolUtils.getInstance().getThreadPool().scheduleAtFixedRate(interruptThread2, 0, 2, TimeUnit.SECONDS);


        TimeUnit.MILLISECONDS.sleep(5000);
        scheduledFuture.cancel(true);
        while (true) {

        }
    }
}
