package com.yasin.lock;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountLatchLern {

    private Object lock = new Object();

    public void lock() {

        synchronized (lock) {
            try {
                Thread.sleep(1000 * 10);

                System.out.println("等了10s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void countLown() {

        // get name representing the running Java virtual machine.
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
// get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);



//        Executor pool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 4; i++) {
//            pool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    lock();
//                }
//            });
//        }
//        ((ExecutorService) pool).shutdown();

        CountDownLatch countDownLatch = new CountDownLatch(10);


        try {
            Thread.sleep(1000 * 20);
//            long i = 0;
//            while (i++ < 100000000000L) {
//
//            }
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
