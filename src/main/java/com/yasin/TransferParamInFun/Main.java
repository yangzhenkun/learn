package com.yasin.TransferParamInFun;

import org.junit.Test;

import com.yasin.extendsLearn.Parent;

public class Main {

	@Test
	public void run(){
		Parent p = new Parent();
		fun(p);
	}
	
	public void fun(Parent p){
		System.out.println(p);
	}
	
	
}
