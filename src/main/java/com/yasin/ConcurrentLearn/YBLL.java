package com.yasin.ConcurrentLearn;

public class YBLL {

	private int i = 0;
	
	private static int is = 0;
	
	public synchronized void inc(){
		i++;
		System.out.println(i);
	}
	
	
	public synchronized  static void incs(){
		is++;
		
		System.out.println(is);
	}
	
	
	
}
