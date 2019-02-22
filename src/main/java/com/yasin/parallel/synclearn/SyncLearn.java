package com.yasin.parallel.synclearn;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * sync关键字作用范围
 *
 * @author yangzhenkun
 * @create 2019-01-23 15:36
 */
public class SyncLearn {

    Executor pool = Executors.newFixedThreadPool(10);


    @Test
    public void run() {

        Function f1 = new Function();
        Function f2 = new Function();

        pool.execute(new Runnable() {
            @Override
            public void run() {
                Function.f1();
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                f2.f2();
            }
        });


        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
