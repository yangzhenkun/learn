package com.yasin.parallel.multThread;

import java.util.concurrent.TimeUnit;

/**
 * @author yangzhenkun
 * @create 2018-10-12 10:24
 */
public class Work {

    public  synchronized void test1(){


        System.out.println("test1 run");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public  synchronized void test2(){

        System.out.println("test2 run");

    }



}
