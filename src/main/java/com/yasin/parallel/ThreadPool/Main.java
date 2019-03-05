package com.yasin.parallel.ThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Main {

	/*
	 * @TODO 线程池测试
	 */
	@Test
	public void threadPool() {

		/*
		 * java提供的统计线程运行数，一开始设置其值为50000，每一个线程任务执行完
		 * 调用CountDownLatch#coutDown()方法（其实就是自减1） 当所有的线程都执行完其值就为0
		 */
		CountDownLatch count = new CountDownLatch(10);
		RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();

		Executor pool = new ThreadPoolExecutor(5,5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		try {

			for (int i = 0; i < 10; i++) {
				pool.execute(new MyRunnable(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000*2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("执行完了");
	}

	/**
	 * @TODO 手动创建线程测试
	 */
	@Test
	public void thread() {
		CountDownLatch count = new CountDownLatch(50000);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("hello");
					count.countDown();
				}
			});
			thread.start();
		}

		while (count.getCount() != 0) {// 堵塞等待5w个线程运行完毕

		}
		long end = System.currentTimeMillis();
		System.out.println("50000个线程都执行完了,共用时:" + (end - start) + "ms");

	}

	@Test
	public void calMaxLength() {

		String input = "adc";
		int max=0;
		int temp=1;
		
		/**
		 * 对整个string进行遍历
		 */
		for(int i=1;i<input.length();i++){
			char pre = input.charAt(i-1);
			char now = input.charAt(i);
			if(now-pre==1){//如果是连续字符串，长度加一
				temp++;
			}else{//如果不是连续的字符串，对之前连续的字符串长度进行判断，看是不是目前最长的，如果是则保存
				  //并且长度计算长度重新计为1
				max=(max>temp?max:temp);
				temp=1;
			}
		}
		//因为上面的程序没有对最后一次连续长度进行比较，所以在这里额外比较一次
		max=(max>temp?max:temp);
		
		//题目要求没有连续的输出0，即没有1这个说法，所以这里进行了判断
		System.out.println((max==1?0:max));

	}
	
	class MyRunnable implements Runnable{
		
		volatile int a =0;
		public MyRunnable(int a) {
			// TODO Auto-generated constructor stub
			this.a = a;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread());
		}
		
	}

}
