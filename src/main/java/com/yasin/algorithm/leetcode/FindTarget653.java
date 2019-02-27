package com.yasin.algorithm.leetcode;

import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2019-02-27 11:32
 */
public class FindTarget653 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void run(){

        TreeNode root = new TreeNode(1);

        System.out.println(findTarget(root,2));


    }


    TreeNode reelNode = null;

    public boolean findTarget(TreeNode root, int k) {

        reelNode = root;

        return core(root, k);
    }

    public boolean core(TreeNode root, int k) {

        if (root == null) {
            return false;
        }
        boolean ans = findValue(reelNode, (k - root.val),root);
        if (ans) {
            return true;
        } else {
            boolean left = core(root.left, k);
            if (left) {
                return true;
            } else {
                return core(root.right, k);
            }


        }

    }


    public boolean findValue(TreeNode root, int target,TreeNode self) {

        if (root == null) {
            return false;
        }
        if (root.val == target && self!=root) {
            return true;
        }
        if (target > root.val) {
            return findValue(root.right, target,self);
        } else {
            return findValue(root.left, target,self);
        }

    }


}
