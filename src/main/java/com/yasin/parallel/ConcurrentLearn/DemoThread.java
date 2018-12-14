package com.yasin.parallel.ConcurrentLearn;

public class DemoThread implements Runnable {

	int i;
	Demo demo;

	public DemoThread(Demo demo, int i) {
		this.i = i;
		this.demo = demo;
	}

	@Override
	public void run() {
		demo.setA(i);
		System.out.println("I:" + i + "," + demo.getA());

	}

}
