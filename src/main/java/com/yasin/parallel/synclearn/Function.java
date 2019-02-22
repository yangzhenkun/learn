package com.yasin.parallel.synclearn;

import java.util.concurrent.TimeUnit;

/**
 * @author yangzhenkun
 * @create 2019-01-23 15:37
 */
public class Function {

    static synchronized public void f1() {

        System.out.println("f1 run");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("f1 end");
    }

    static synchronized public void f2() {

        System.out.println("f2 run");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("f2 end");


    }


}
