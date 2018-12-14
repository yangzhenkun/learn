package com.yasin.jdklearn.extendsLearn;

public abstract class AP {
	
	static Parent p = null;
	
	static{
		p = new Parent();
		System.out.println("p static run");
	}

}
