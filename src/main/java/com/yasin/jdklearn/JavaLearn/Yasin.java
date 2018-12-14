package com.yasin.jdklearn.JavaLearn;

@Learn
public class Yasin {
	
	@FiledLearn
	private int level;
	
	@FiledLearn(name="xq")
	private String xq;
	
	private String a;
	
	
	@MethodLearn(name="test")
	public void setMain(){
		
	}
	
	public void setA(String a){
		this.a=a;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return level;
	}
	
	public String getA(){
		return a;
	}
	
	
	
}
