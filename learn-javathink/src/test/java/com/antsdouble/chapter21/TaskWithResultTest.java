package com.antsdouble.chapter21;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @ClassName TaskWithResultTest
 * @Description test
 * @date 4/10/2019
 * @Author liyy
 * @Version 1.0
 */
public class TaskWithResultTest {

    @Test
    public void callableTest() throws InterruptedException, ExecutionException {
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult(i, latch)));
        }
        latch.await();
        for (Future<String> fs : results) {
            System.out.println(fs.get());
        }
        executorService.shutdown();
    }

    @Test
    public void feiboTest() throws InterruptedException, ExecutionException {
        Integer sum = 0;
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<ArrayList<Integer>> res = executorService.submit(new Feibo(latch, 20));
        latch.await();
        for (Integer number : res.get()) {
            System.out.println(number);
            sum += number;
        }
        executorService.shutdown();
        System.out.println(sum);

    }
}
