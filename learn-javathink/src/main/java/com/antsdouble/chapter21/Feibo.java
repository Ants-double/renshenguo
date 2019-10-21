package com.antsdouble.chapter21;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Feibo
 * @Description feibo
 * @date 4/10/2019
 * @Author liyy
 * @Version 1.0
 */
public class Feibo implements Callable<ArrayList<Integer>> {

    CountDownLatch latch = null;
    private Integer num = 20;

    public Feibo() {
    }

    public Feibo(CountDownLatch latch, Integer num) {
        this.latch = latch;
        this.num = num;
    }

    private Integer getFeibo(Integer integer) {
        if (integer == 1 || integer == 2) {
            return 1;
        } else {
            return getFeibo(integer - 1) + getFeibo(integer - 2);
        }
    }

    public ArrayList<Integer> call() throws Exception {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=1;i<=num;i++){
            result.add(getFeibo(i));
        }
        this.latch.countDown();
        return result;

    }
}
