package com.antsdouble.chapter21;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName TaskWithResult
 * @Description taskwithresult
 * @date 4/10/2019
 * @Author liyy
 * @Version 1.0
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    CountDownLatch latch=null;

    public TaskWithResult(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    public String call() throws Exception {
        latch.countDown();
        return "result of TaskWithResult----"+id;
    }
}
