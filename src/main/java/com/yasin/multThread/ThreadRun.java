package com.yasin.multThread;

import jdk.nashorn.internal.runtime.WithObject;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author yangzhenkun
 * @create 2018-10-12 10:25
 */
public class ThreadRun {

    @Test
    public void test(){

        Work w1 = new Work();
        Work w2 = new Work();
//        Executor pool = Executors.newFixedThreadPool(10);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                w1.test1();
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                w1.test2();
            }
        });

        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("end end end");

    }




}
