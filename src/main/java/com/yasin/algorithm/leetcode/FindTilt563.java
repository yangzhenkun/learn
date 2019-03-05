package com.yasin.algorithm.leetcode;

import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2019-03-01 10:01
 */
public class FindTilt563 {

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

        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t2 =new TreeNode(2);
        t2.left=t4;
        TreeNode t3 = new TreeNode(3);
        t3.left=t5;
        TreeNode t1 = new TreeNode(1);
        t1.left=t2;
        t1.right=t3;


        System.out.println(findTilt(t1));
    }


    int sum = 0;

    public int findTilt(TreeNode root) {

        childTreeSum(root);

        return sum;
    }

    /**
     * 计算改节点和
     * @param root
     * @return
     */
    public int childTreeSum(TreeNode root){

        if(root==null){
            return 0;
        }
        int left = childTreeSum(root.left);
        int right = childTreeSum(root.right);

        sum+=(Math.abs(left-right));

        return left+right+root.val;
    }




}
