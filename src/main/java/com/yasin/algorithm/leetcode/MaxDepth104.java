package com.yasin.algorithm.leetcode;

/**
 * @author yangzhenkun
 * @create 2019-02-22 11:05
 */
public class MaxDepth104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }else{

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return(Math.max(left,right)+1);
        }

    }




}
