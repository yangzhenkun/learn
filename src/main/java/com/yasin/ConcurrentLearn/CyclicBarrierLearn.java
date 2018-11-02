package com.yasin.ConcurrentLearn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class CyclicBarrierLearn {

	@Test
	public void test() {

		ExecutorService tp = Executors.newFixedThreadPool(2);
		CyclicBarrier cb = new CyclicBarrier(3);

		CB1 cb1 = new CB1(cb);
		CB2 cb2 = new CB2(cb);

		tp.execute(cb1);
		tp.execute(cb2);

		try {
			cb.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main thread");
		
		tp.shutdown();

		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private class CB1 implements Runnable {

		private CyclicBarrier cb;

		CB1(CyclicBarrier cb) {
			this.cb = cb;
		}

		public void run() {
			System.out.println("cb1开始执行了");
			try {
				Thread.sleep(10000);
				System.out.println("cb1执行完开始等待...");
				cb.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}

			System.out.println("cb1等待完成");

		}

	}

	private class CB2 implements Runnable {

		private CyclicBarrier cb;

		CB2(CyclicBarrier cb) {
			this.cb = cb;
		}

		public void run() {
			System.out.println("cb2开始执行了");
			try {
				Thread.sleep(100);
				
				System.out.println("cb2早完成了，一直等");
				System.out.println("cb2早完成了，一直等");
				System.out.println("cb2早完成了，一直等");
				
				cb.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}

			System.out.println("cb2等待完成");

		}

	}

}
