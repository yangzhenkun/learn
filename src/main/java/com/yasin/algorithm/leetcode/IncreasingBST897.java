package com.yasin.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangzhenkun01
 * @Date: 2019/2/24
 */
public class IncreasingBST897 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void run() {

        TreeNode root = new TreeNode(212);

        increasingBST(root);

        System.out.println("");


    }

    List<Integer> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {

        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cnode = root;

        while (cnode != null || !stack.isEmpty()) {
            while (cnode != null) {
                stack.add(cnode);
                cnode = cnode.left;
            }

            if (!stack.isEmpty()) {
                cnode = stack.pop();
                list.add(cnode.val);
                cnode = cnode.right;
            }

        }

        int length = list.size();
        TreeNode newR = new TreeNode(list.get(length - 1));
        TreeNode newP = newR;
        for (int i = length - 2; i >= 0; i--) {
            newP = new TreeNode(list.get(i));
            newP.right = newR;
            newR = newP;
        }
        return newP;
    }

    public void hxbl(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        stack.add(root);

        while (!stack.isEmpty()) {

            cur = stack.peek();

            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.println(cur.val);
                stack.pop();
                pre=cur;
            }else{
                if(cur.right!=null){
                    stack.add(cur.right);
                }
                if(cur.left!=null){
                    stack.add(cur.left);
                }

            }


        }


    }

    public void qxbl(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode cur = null;

        while (!stack.isEmpty()) {

            cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
        }
    }

    public void zxbl(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }

}
