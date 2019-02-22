package com.yasin.parallel.ConcurrentLearn;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 *
 * 可以用该类控制最大线程处理数量
 *
 * @author yangzhenkun
 * @create 2019-02-13 15:19
 */
public class SemaphoreLearn {


    @Test
    public void run() {
        try {

            Semaphore semaphore = new Semaphore(3, true);

            System.out.println("当前可用许可证:" + semaphore.availablePermits());

            semaphore.acquire();
            System.out.println("当前可用许可证:" + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println("当前可用许可证:" + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println("当前可用许可证:" + semaphore.availablePermits());
            semaphore.release();

            semaphore.acquire();
            System.out.println("当前可用许可证:" + semaphore.availablePermits());




        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
