package com.yasin.algorithm.rbtree;

/**
 *
 * 树的节点
 * 
 * @author yangzhenkun
 *
 */
public class TreeNode {
	
	private TreeNode left;
	private TreeNode right;
	private Object value;
	public TreeNode(TreeNode left, TreeNode right, Object value) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
