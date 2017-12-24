package com.yasin.ConcurrentLearn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class ThreadLocalLearn {

	
	@Test
	public void run(){
		
		Demo demo = new Demo();
		ExecutorService pool = Executors.newFixedThreadPool(100);
		for(int i=0;i<100;i++){
			
			pool.execute(new DemoThread(demo, i));
			
		}
		
		
		while(true);
		
	}
	
	
	
	
	
	
}
