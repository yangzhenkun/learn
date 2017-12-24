package com.yasin.ConcurrentLearn;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class CountDownLatchLearn {

	
	@Test
	public void test() throws InterruptedException{
		
		CountDownLatch latch = new CountDownLatch(2);
		
		
		
		latch.await();
		System.out.println("执行完毕");
		
	}
	
	
}
