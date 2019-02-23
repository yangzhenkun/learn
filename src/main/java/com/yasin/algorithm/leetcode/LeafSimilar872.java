package com.yasin.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangzhenkun01
 * @Date: 2019/2/23
 */
public class LeafSimilar872 {

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

        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        t2.left = t7;
        t2.right = t4;
        TreeNode t9 = new TreeNode(9);
        TreeNode t8 = new TreeNode(8);
        TreeNode t5 = new TreeNode(5);
        t5.left = t6;
        t5.right = t2;
        TreeNode t1 = new TreeNode(1);
        t1.left = t9;
        t1.right = t8;
        TreeNode t3 = new TreeNode(3);
        t3.left = t5;
        t3.right = t1;

        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a4 = new TreeNode(4);
        TreeNode a9 = new TreeNode(9);
        TreeNode a8 = new TreeNode(8);
        TreeNode a2 = new TreeNode(2);
        a2.left = a9;
        a2.right = a8;
        TreeNode a5 = new TreeNode(5);
        a5.left = a6;
        a5.right = a7;
        TreeNode a1 = new TreeNode(1);
        a1.left = a4;
        a1.right = a2;
        TreeNode a3 = new TreeNode(3);
        a3.left = a5;
        a3.right = a1;

        System.out.println(leafSimilar(t3,a3));

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = getLeaf(root1);
        List<Integer> leaf2 = getLeaf(root2);
        if(leaf1.size()!=leaf2.size()){
            return false;
        }else{
            for (int i = 0; i < leaf1.size(); i++) {
                if(!leaf1.get(i).equals(leaf2.get(i)) ){
                    return false;
                }
            }

            return true;
        }
    }


    public List<Integer> getLeaf(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty()) {

            TreeNode cnode = stack.pop();
            if(cnode.left==null&&cnode.right==null){
                list.add(cnode.val);
            }
            if(cnode.right!=null){
                stack.add(cnode.right);
            }
            if(cnode.left!=null){
                stack.add(cnode.left);
            }

        }

        return list;
    }


}
