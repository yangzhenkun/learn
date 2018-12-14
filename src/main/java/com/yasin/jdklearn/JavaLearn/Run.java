package com.yasin.jdklearn.JavaLearn;

import org.junit.Test;

public class Run {
	
	public class A{
		
		public int a=0;
		
	}
	
	
	@Test
	public void run(){
		
		A a = new A();
		a.a=1;
		
		Object o = a;//子类转父类
		
		A b = (A)o;//还可以转回子类
		System.out.println(b.a);
		
		Object o1 = new Object();
		A c = (A)o1;//这时就会报错,提示不能强转
		
		System.out.println(c.a);
	}
	
	
}
