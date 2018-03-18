package com.yasin.multThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;
import org.junit.experimental.theories.Theories;

public class App {

	
	
	
	AtomicBoolean b = new AtomicBoolean(false);
	
	@Test
	public void run() {
		
		A a = new A();
		a.setia(0);
		 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		 for(int i=0;i<30;i++){
			fixedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					
//					if(b.compareAndSet(false, true)){//即判断b==false并且设置为true这一系列操作为原子性
//						
//					}
					synchronized (a) {
						if(a.getia()<1){
							System.out.println(a.getia());
							a.setia((a.getia()+1));
						}
					}
					
					
					
				}
			}); 
		 }
		
		
		//MyThreadPool
		
		
		
		
	}
	
	
	class A{
		
		private int ia;
		
		public void setia(int a){
			this.ia=a;
		}
		
		public int getia(){
			return this.ia;
		}
		
	}

		
	

}
