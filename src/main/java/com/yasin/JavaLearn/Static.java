package com.yasin.JavaLearn;

public class Static {
	
//	static{
//		System.out.println("我在静态区");
//	}
//	
	
	static public class A{
		Static s = new Static();
		
		static{
			System.out.println("我看看内部类静态快执行吗");
		}
	}
	
	static int i=0;
	
	public synchronized static void run(){
		
		if(i==0){
			System.out.println("我在普通方法去");
			i++;
		}
		
	}

}
