package com.yasin.algorithm.leetcode;

/**
 * @author yangzhenkun
 * @create 2019-03-01 18:12
 */
public class IsBalanced110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {

        deep(root);

        return isBalance;
    }

    public int deep(TreeNode root){

        if(root==null){
            return 0;
        }

        int left = deep(root.left);
        int right = deep(root.right);

        if(Math.abs(left-right)>1){
            isBalance=false;
        }

        return Math.max(left,right)+1;
    }



}