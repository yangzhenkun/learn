package com.yasin.algorithm.tree;

import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2019-01-18 16:39
 */
public class GetHeight {

    class TreeNode {

        TreeNode leftNode;
        TreeNode rightNode;

        Object value;
    }

    int height(TreeNode node) {

        if (node == null)
            return 0;

        int lheight = height(node.leftNode);
        int rheight = height(node.rightNode);

        return Math.max(lheight+1, rheight+1);
    }


    @Test
    public void run() {

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


        System.out.println(height(root));

    }


}
