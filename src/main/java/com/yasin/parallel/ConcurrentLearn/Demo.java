package com.yasin.parallel.ConcurrentLearn;

public class Demo {

	
	ThreadLocal<Integer> a = new ThreadLocal<>();

	public int getA() {
		return a.get();
	}

	public void setA(int a) {
		this.a.set(a);
	}

}
