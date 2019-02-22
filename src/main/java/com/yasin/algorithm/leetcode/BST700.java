package com.yasin.algorithm.leetcode;

/**
 * @author yangzhenkun
 * @create 2019-02-22 15:45
 */
public class BST700 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (val == root.val) {
            return root;
        } else {

            TreeNode left = searchBST(root.left, val);
            TreeNode right = searchBST(root.right, val);

            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }

            return null;

        }


    }

}
