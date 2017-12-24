package com.yasin.ConcurrentLearn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class SyncTest {

	@Test
	public void run(){
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		YBLL bll = new YBLL();
		YBLL bll2 = new YBLL();
		
		for(int i=0;i<100;i++){
			pool.execute(new Td(i,bll,bll2));
		}
		
		
		while(true);
		
	}
	
	
	class Td implements Runnable{

		int i;
		YBLL b1;
		YBLL b2;
		
		Td(int i,YBLL b1,YBLL b2){
			this.i=i;
			this.b1=b1;
			this.b2=b2;
		}
		
		@Override
		public void run() {
			if(i%2==0){
				b1.inc();
			}else{
				b2.inc();
			}
		}
		
	}
	
	
	
	
}
