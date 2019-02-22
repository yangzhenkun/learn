package com.yasin.jdklearn;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author yangzhenkun
 * @create 2019-02-13 10:43
 */
public class ClassNum {

    Integer count = new Integer(0);


    @Test
    public void run() {

        Executor pool = Executors.newFixedThreadPool(10);
        Task task = new Task();

        while (true) {

            pool.execute(task);

        }

    }

    public class Task implements Runnable {

//        Integer count = null;
//
//        public Task(Integer i){
//            this.count = i;
//        }

        @Override
        public void run() {
            synchronized (count) {

                System.out.println((count % 3) + 1);
                count++;
            }
        }
    }


}
