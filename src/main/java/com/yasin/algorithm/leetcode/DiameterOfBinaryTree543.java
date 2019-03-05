package com.yasin.algorithm.leetcode;

import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2019-03-05 17:49
 */
public class DiameterOfBinaryTree543 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        return Math.max(Math.max(left,right),(leftMaxDepth+rightMaxDepth+2));
    }

    public int maxDepth(TreeNode root){

        if(root==null){
            return -1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return (Math.max(left,right)+1);
    }


    @Test
    public void run(){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;



        System.out.println(diameterOfBinaryTree(t1));


    }



}
