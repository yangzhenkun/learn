package com.yasin.parallel.ThreadPool;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author yangzhenkun
 * @create 2018-10-10 10:56
 */
public class ThreadLearn {

    @Test
    public void multiStart(){



        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello,world");
                countDownLatch.countDown();
            }
        });

        thread.start();
        thread.interrupt();

        try {
            thread.join();
//            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
