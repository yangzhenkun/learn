package com.yasin.algorithm.leetcode;

/**
 * @author: yangzhenkun01
 * @Date: 2019/2/23
 */
public class IsSameTree100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == q && p == null) {
            return true;
        }

        if (!(p != null && q != null && p.val == q.val)) {
            return false;
        }

        boolean l = isSameTree(p.left, q.left);
        if (!l) {
            return false;
        }
        boolean r = isSameTree(p.right, q.right);
        return r;
    }


}
