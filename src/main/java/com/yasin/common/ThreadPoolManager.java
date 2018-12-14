package com.yasin.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolManager {

    private static Map<String, ThreadPoolExecutor> threadPoolExecutorMap = new ConcurrentHashMap<String, ThreadPoolExecutor>();

    public static ThreadPoolExecutor createThreadPoolExecutor(final String poolName,
                                                              final int corePoolSize,
                                                              final int maximumPoolSize,
                                                              final int workQueueSize) {

        ThreadPoolExecutor o = threadPoolExecutorMap.get(poolName);
        if (o != null) {
            return o;
        }

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(workQueueSize),
                new ThreadFactory() {
                    private final AtomicInteger counter = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, poolName + "-Thread-" + counter.getAndIncrement());
                    }
                },

                new MyPolicy(poolName)
        );

        ThreadPoolExecutor oldThreadPoolExecutor = threadPoolExecutorMap.putIfAbsent(poolName, threadPoolExecutor);
        if (oldThreadPoolExecutor != null) {
            threadPoolExecutor = oldThreadPoolExecutor;
        }

        return threadPoolExecutor;
    }

    public static class MyPolicy implements RejectedExecutionHandler {
        private String poolName;
        private RejectedExecutionHandler handler;

        public MyPolicy(String poolName) {
            this.poolName = poolName;
            this.handler = new ThreadPoolExecutor.DiscardOldestPolicy();
        }

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            handler.rejectedExecution(r, e);
        }
    }

    public static Map<String, ThreadPoolExecutor> getThreadPoolExecutorMap() {
        return threadPoolExecutorMap;
    }

}
