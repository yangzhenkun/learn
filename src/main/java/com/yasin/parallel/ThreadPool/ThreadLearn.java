package com.yasin.parallel.ThreadPool;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author yangzhenkun
 * @create 2018-10-10 10:56
 */
public class ThreadLearn {

    @Test
    public void multiStart() {


        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * 3);
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




    public static void main(String[] args) throws InterruptedException {

        ExecutorService execute = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        execute.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("=====11=======");
            }
        });

        TimeUnit.SECONDS.sleep(30);


        execute.execute(new Run1());

        TimeUnit.SECONDS.sleep(5);

        execute.execute(new Run2());
        //execute.shutdown();

    }


    private static class Run1 implements Runnable {

        @Override
        public void run() {
            int count = 0;
            while (true) {
                count++;

                System.out.println("-------222-------------"+ count);

                if (count == 10) {
                    System.out.println(1 / 0);
                }

                if (count == 20) {

                    System.out.println("count="+ count);
                    break;
                }
            }
        }
    }

        private static class Run2 implements Runnable {

        public Run2() {

            System.out.println("run2 构造函数");
        }

        @Override
        public void run() {

            System.out.println("run222222222");
        }
    }


}
