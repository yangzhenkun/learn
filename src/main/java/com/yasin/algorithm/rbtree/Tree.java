package com.yasin.algorithm.rbtree;

import org.junit.Test;

public class Tree {
	
	
	/**
	 * 			root
	 * 			/	\
	 * 		   l     r
	 * 		  / \   /
	 * 		 ll lr  rl
	 *          /
	 *         lrl
	 *           \
	 *           lrlr 
	 * @return
	 */
	public TreeNode buildTree() {
		
		
		
		TreeNode lrlr = new TreeNode(null,null,12);
		TreeNode lrl = new TreeNode(null,lrlr,11);
		TreeNode lr = new TreeNode(lrl,null,111);
		TreeNode ll = new TreeNode(null,null,1);
		TreeNode rl = new TreeNode(null,null,111);
		TreeNode l = new TreeNode(ll,lr,1);
		TreeNode r = new TreeNode(rl,null,222);
		
		TreeNode root = new TreeNode(l,r,3);
		
		return root;
	}
	
	public int  getTreeDeep(TreeNode root) {
		
		int left=0;
		int right = 0;
		
		if(root.getLeft()!=null)
			left = getTreeDeep(root.getLeft())+1;
		if(root.getRight()!=null)
			right = getTreeDeep(root.getRight())+1;
		
		return left>=right?left:right;
	}
	
	@Test
	public void test() {
		TreeNode root = buildTree();
		System.out.println(getTreeDeep(root)+1);
	}

}
