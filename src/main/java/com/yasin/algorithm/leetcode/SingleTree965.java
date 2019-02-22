package com.yasin.algorithm.leetcode;

/**
 * @author yangzhenkun
 * @create 2019-02-22 15:04
 */
public class SingleTree965 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isUnivalTree(TreeNode root) {

        return bl(root);

    }


    public boolean bl(TreeNode root){

        boolean ans = true;

        if(root.left!=null){
            ans &=(root.val==root.left.val);
            ans &=bl(root.left);
        }
        if(root.right!=null){
            ans &=(root.val==root.right.val);
            ans &= bl(root.right);
        }

        return ans;
    }


}
