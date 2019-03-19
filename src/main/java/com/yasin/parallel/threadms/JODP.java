package com.yasin.parallel.threadms;

import java.util.concurrent.TimeUnit;

/**
 * 面试题：两个线程，一次打印即偶数
 *
 * @author yangzhenkun
 * @create 2019-03-15 17:40
 */
public class JODP {

    static class Task implements Runnable {

        static int count = 0;

        @Override
        public void run() {

            while (count < 100) {

                synchronized (Task.class) {
                    System.out.println(Thread.currentThread().getName() + "::" + count++);
                    Task.class.notify();//唤醒wait的线程

                    try {
                        Task.class.wait();//当前线程wait，释放锁，线程进入睡眠状态

//                        System.out.println(Thread.currentThread().getName());//已经沉睡的线程醒来继续执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }



        }
    }


    public static void main(String[] args) {

        int n = 5;

        for (int i = 0; i < n; i++) {

            new Thread(new Task(),""+i).start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


}
