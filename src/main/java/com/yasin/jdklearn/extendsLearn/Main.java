package com.yasin.jdklearn.extendsLearn;

import org.junit.Test;

public class Main {
	
	@Test
	public void run(){
		
		AS as = new AS();
		AS2 as2 = new AS2();
		
		System.out.println(as.getP()==as2.getP());
		
		
	}

	
	public Parent getP(){
		Son s = new Son();
		s.setP(1);
		s.setS("son");
		return s;
		
//		Parent p = new Parent();
//		p.setP(1);
//		return p;
	
	}
}
