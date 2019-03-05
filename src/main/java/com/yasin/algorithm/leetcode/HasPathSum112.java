package com.yasin.algorithm.leetcode;

/**
 * @author yangzhenkun
 * @create 2019-03-05 17:44
 */
public class HasPathSum112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int count = 0;
    boolean hasPathSum = false;

    public boolean hasPathSum(TreeNode root, int sum) {

        bl(root,sum);

        return hasPathSum;
    }

    public void bl(TreeNode root,int sum){

        if(root==null){
            return;
        }
        count+=root.val;
        if(root.left==null&&root.right==null&&sum==count){
            hasPathSum=true;
            return;
        }
        bl(root.left,sum);
        bl(root.right,sum);

        count-=root.val;
    }


}
