package com.yasin.algorithm;

import org.junit.Test;

public class RBTreeTest {
	
	
	@Test
	public void test(){
		
		RBTree<Integer> tree = new RBTree<>();
		
		for(int i=1;i<10;i++)
			tree.insert(i);
		
		tree.preOrder();
		
		
	}
	

}
