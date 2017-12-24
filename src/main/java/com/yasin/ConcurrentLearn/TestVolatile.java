package com.yasin.ConcurrentLearn;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestVolatile {


	public static void main(String[] args){

		ExecutorService pool = Executors.newCachedThreadPool();
		
		for(int i=0;i<10;i++){	
			
			try {
				Thread.sleep(1000*3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			pool.execute(new Runnable() {
				
				@Override
				public void run() {
					
					System.out.println(Thread.currentThread());
				}
			});
			
		}
		
		
		
//		ThreadDemo t = new ThreadDemo();
//		
//		new Thread(t).start();
//		
//		while(true){
//			if(t.isFlag()){
//				System.out.println("------------");
//				break;
//			}
//			
//		}
		
		
	}
	
	
	static class ThreadDemo implements Runnable{
		
		public ThreadDemo(){}
		
		 private boolean flag = false;
		
		@Override
		public void run() {
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			flag=true;
			System.out.println("flag="+flag);
			
		}

		public boolean isFlag() {
			return flag;
		}

		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		
		
		
	}
	
}
