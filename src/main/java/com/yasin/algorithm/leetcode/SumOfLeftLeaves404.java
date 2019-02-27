package com.yasin.algorithm.leetcode;

import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2019-02-27 14:45
 */
public class SumOfLeftLeaves404 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {

       core(root,false);

        return sum;
    }

    public void core(TreeNode root,boolean isLeft){

        if(root==null){
            return;
        }
        if(isLeft&&root.left==null&&root.right==null){
            sum+=root.val;
        }
        core(root.left,true);
        core(root.right,false);

    }


}
