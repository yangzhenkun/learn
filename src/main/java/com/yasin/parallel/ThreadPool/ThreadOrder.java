package com.yasin.parallel.ThreadPool;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程顺序保证
 *
 * @author yangzhenkun
 * @create 2019-01-22 10:10
 */
public class ThreadOrder {


    @Test
    public void joinTest() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println("t1 run");
            }
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println("t2 run");
            }
        });

        t2.start();

        System.out.println("main run");

    }

    Integer i = 0;

    @Test
    public void ts() {

        Executor pool = Executors.newFixedThreadPool(10);

        for (int j = 0; ; j++) {

            pool.execute(new T());

        }
    }

    class T implements Runnable {

        @Override
        public void run() {

            synchronized (i) {
                System.out.println((i % 3) + 1);
                i++;
            }

        }
    }


}
