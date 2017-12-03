package com.yasin.lock;

/**
 * 
 * @author yasin 死锁demo
 */
public class DeadLock {

	static Object a = new Object();
	static Object b = new Object();
	
	public static void main(String[] args) {

		new Thread(new Runnable() {

			public void run() {
				while (true) {
					synchronized (a) {
						System.out.println(Thread.currentThread().getName() + "a run...");
						synchronized (b) {
							System.out.println(Thread.currentThread().getName() + "b run...");
						}
					}
				}
				

			}

		}).start();

		new Thread(new Runnable() {

			public void run() {
				while (true) {
					synchronized (b) {
						System.out.println(Thread.currentThread().getName() + "b run...");
						synchronized (a) {
							System.out.println(Thread.currentThread().getName() + "a run...");
						}
					}
				}
				

			}

		}).start();

	}

}
