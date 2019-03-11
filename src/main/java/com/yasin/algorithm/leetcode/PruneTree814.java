package com.yasin.algorithm.leetcode;

/**
 * @author yangzhenkun
 * @create 2019-03-07 10:08
 */
public class PruneTree814 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode pruneTree(TreeNode root) {

        if(root==null){
            return null;
        }

        int ls = sum(root.left);
        if(ls==0){
            root.left=null;
        }else {
            pruneTree(root.left);
        }

        int rs = sum(root.right);
        if(rs==0){
            root.right=null;
        }else {
            pruneTree(root.right);
        }

        return root;
    }


    public int sum(TreeNode root){

        if(root==null){
            return 0;
        }

        return sum(root.left)+sum(root.right)+root.val;
    }


}
