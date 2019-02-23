package com.yasin.algorithm.leetcode;

/**
 * @author: yangzhenkun01
 * @Date: 2019/2/23
 */
public class TrimBST669 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if(root==null){
            return null;
        }
        if(root.val>=L&&root.val<=R){
            root.left=trimBST(root.left,L,R);
            root.right=trimBST(root.right,L,R);
            return root;
        }else if(root.val<L){
            return trimBST(root.right,L,R);
        }else{
            return trimBST(root.left,L,R);
        }

    }


}
