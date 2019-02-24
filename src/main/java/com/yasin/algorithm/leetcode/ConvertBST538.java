package com.yasin.algorithm.leetcode;

import java.util.Stack;

/**
 * @author: yangzhenkun01
 * @Date: 2019/2/23
 */
public class ConvertBST538 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        if(root==null){
            return null;
        }

        convertBST(root.right);
        root.val+=sum;
        sum=root.val;
        convertBST(root.left);
        return root;
    }

}
