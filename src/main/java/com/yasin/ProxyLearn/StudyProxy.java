package com.yasin.ProxyLearn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudyProxy implements InvocationHandler{

	//真实要被代理的对象
	private Object study;
	
	public StudyProxy(Object study){
		this.study=study;
	}
		
	/**
	 * 当被代理对象执行自己的方法时，便会执行这个方法
	 */
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		
		Object obj=null;
		
		System.out.println("代理执行前我可以执行一些操作");
		
		//执行被代理对象的方法
		obj = method.invoke(study, args);
		
		
		System.out.println("代理执行后我还可以执行一些操作");
		
		return obj;
	}

}
