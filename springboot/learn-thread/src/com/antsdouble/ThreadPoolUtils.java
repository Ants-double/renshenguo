package com.antsdouble;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.PrimitiveIterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author lyy
 * @description
 * @date 2019/4/30
 */
public class ThreadPoolUtils {
    private static ScheduledExecutorService executorService;

    public ThreadPoolUtils() {
        //.priority(Thread.MAX_PRIORITY)
        executorService = new ScheduledThreadPoolExecutor(10, new BasicThreadFactory.Builder()
                .namingPattern("sysdate-schedule-pool-%d")
                .daemon(true)
                .build());
    }

    private static class PluginConfigHolder {
        private final static ThreadPoolUtils INSTANCE = new ThreadPoolUtils();
    }

    public static ThreadPoolUtils getInstance() {
        return PluginConfigHolder.INSTANCE;
    }

    public ScheduledExecutorService getThreadPool() {
        return executorService;
    }

}
