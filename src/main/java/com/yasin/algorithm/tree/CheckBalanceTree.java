package com.yasin.algorithm.tree;

import org.junit.Test;

/**
 * 判断一棵二叉树是否是平衡树
 * 根据定义，平衡术的左右子树的最大高度差不能超过1
 * 解法：获取到每个节点的最大深度进行比较即可
 *
 * @author yangzhenkun
 * @create 2019-01-18 14:35
 */
public class CheckBalanceTree {

    class TreeNode {

        TreeNode() {
        }

        TreeNode leftNode;
        TreeNode rightNode;

        int leftDepth = 1;
        int rightDepth = 1;

        int value;

    }


    boolean findMaxDepth(TreeNode node) {

        if (node == null)
            return true;

        if (node.leftNode != null) {
            findMaxDepth(node.leftNode);
        }
        if (node.rightNode != null) {
            findMaxDepth(node.rightNode);
        }

        if (node.leftNode != null) {
            int max = Math.max(node.leftNode.leftDepth, node.leftNode.rightDepth);
            node.leftDepth = max + 1;
        }

        if (node.rightNode != null) {
            int max = Math.max(node.rightNode.leftDepth, node.rightNode.rightDepth);
            node.rightDepth = max + 1;
        }

        if (Math.abs((node.leftDepth - node.rightDepth)) > 1) {
            return false;
        }

        return true;
    }


    @Test
    public void test() {

        /**
         O
         / \
         O  O
         / \
         O  O
         / \
         O  O
         /   |
         O    O
         /     \
         O      O
         /       \
         O        O
         */
        TreeNode l71 = new TreeNode();
        TreeNode l72 = new TreeNode();
        TreeNode l6 = new TreeNode();
        l6.leftNode = l71;
        TreeNode l62 = new TreeNode();
        l62.rightNode = l72;
        TreeNode l5 = new TreeNode();
        l5.leftNode = l6;
        TreeNode l52 = new TreeNode();
        l52.rightNode = l62;
        TreeNode l41 = new TreeNode();
        l41.leftNode = l5;
        TreeNode l42 = new TreeNode();
        l42.rightNode = l52;
        TreeNode l31 = new TreeNode();
        TreeNode l32 = new TreeNode();
        l32.leftNode = l41;
        l32.rightNode = l42;
        TreeNode l21 = new TreeNode();
        l21.leftNode = l31;
        l21.rightNode = l32;
        TreeNode l22 = new TreeNode();
        TreeNode root = new TreeNode();
        root.leftNode = l21;
        root.rightNode = l22;
        boolean f = findMaxDepth(root);

        System.out.println(f);

    }

    @Test
    public void testTrue() {

        TreeNode root = new TreeNode();
        TreeNode t21 = new TreeNode();
        TreeNode t22 = new TreeNode();
        TreeNode t31 = new TreeNode();
        TreeNode t32 = new TreeNode();
        TreeNode t33 = new TreeNode();
        TreeNode t34 = new TreeNode();
        TreeNode t41 = new TreeNode();

        TreeNode t42 = new TreeNode();

        root.leftNode=t21;
        root.rightNode=t22;
        t21.leftNode=t31;
        t21.rightNode=t32;
        t22.leftNode=t33;
        t22.rightNode=t34;

        t33.leftNode=t42;
        t31.rightNode=t41;

        boolean f = findMaxDepth(root);

        System.out.println(f);

    }



}
