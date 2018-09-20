package com.yasin.algorithm;


import org.junit.Test;

public class LRUTest {

	
	@Test
	public void testLRU() {
		
		LRU lru = new LRU(5);
		
		for(int i=0;i<10;i++) {
			lru.set(i+"", i);
			lru.get("0");
		}
		
		
		for(int i=0;i<10;i++) {
			System.out.println(lru.get(""+i));
		}
		
	}
	
	
}
