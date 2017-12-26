package com.yasin.parallel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ParallelTest {

	
	@Test
	public void testOnThread() {
		
		long start = System.currentTimeMillis();
		
		for(int i=0;i<1000;i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
		
		
	}
	
	
	@Test
	public void testMultiThread() {
		
		long start = System.currentTimeMillis();
		ExecutorService pool = Executors.newFixedThreadPool(50);
		final CountDownLatch latch = new CountDownLatch(1000);
		
		for(int i=0;i<1000;i++) {
			pool.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(10);
						System.out.println("run");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					latch.countDown();
				}
			});
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		
		System.out.println(end-start);
	}
	
	
	@Test
	public void testForkJoin() {
		
		long start = System.currentTimeMillis();
		CountDownLatch latch = new CountDownLatch(998);
		Run run = new Run(latch,0,1000);
		ForkJoinPool pool = new ForkJoinPool();
		pool.submit(run);
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}
	
	public class Run extends RecursiveAction{

		private static final int THRESHOLD = 50;
		private int low;
		private int high;
		private CountDownLatch latch;
		
		public Run(CountDownLatch latch,int low,int high) {
			this.high=high;
			this.low=low;
			this.latch=latch;
		}
		
		@Override
		protected void compute() {
			
			//小于阈值直接计算
			if(high-low<THRESHOLD) {
				try {
					for(int i=low;i<high;i++) {
						
						Thread.sleep(10);
						latch.countDown();
						System.out.println(Thread.currentThread().getName());
						System.out.println(latch.getCount());
					}
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				int mid =(low+high)>>1;
				Run left = new Run(latch,low,mid);
				Run right = new Run(latch,mid+1,high);
				
				//分别计算
				left.fork();
				right.fork();
				
				//合并  对于有结果的运行需要进行join
//				return left.join()+right.join();
				
			}
			
		}
		
		
		
	}
	
	
}
