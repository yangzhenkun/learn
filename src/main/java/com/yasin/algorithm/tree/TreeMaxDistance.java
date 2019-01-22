package com.yasin.algorithm.tree;

import com.yasin.algorithm.rbtree.Tree;
import org.junit.Test;

/**
 * 求解一颗二叉树节点的最大距离
 *
 * @author yangzhenkun
 * @create 2018-12-24 16:54
 */
public class TreeMaxDistance {

    private class TreeNode {

        TreeNode leftNode;
        TreeNode rightNode;

        int leftMaxDep;//左子节点最大深度
        int rightMaxDep;//右子节点最大深度

        Object value;
    }


    public int maxDis = 0;

    /**
     * 整个树中最大节点的距离，一定是两个叶子节点到他们第一个相交的父级节点（包括一个父级节点的一个子节点为空的情况，这时候可以把该父节点看作是一个叶子节点）
     *
     * 这样我们遍历全部节点的左右子树的最大深度，同时获取全部节点的leftMaxDep+rightMaxDep的最大值，就是我们的最大距离了
     *
     * @param root
     */
    public void FindMaxDis(TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.leftNode == null) {
            root.leftMaxDep = 0;
        }

        if (root.rightNode == null) {
            root.rightMaxDep = 0;
        }

        if (root.leftNode != null) {
            FindMaxDis(root.leftNode);
        }

        if (root.rightNode != null) {
            FindMaxDis(root.rightNode);
        }

        /**
         * 获得左子节点最大深度
         */
        if (root.leftNode != null) {

            int tempMax = 0;
            if (root.leftNode.leftMaxDep > root.leftNode.rightMaxDep) {
                tempMax = root.leftNode.leftMaxDep;
            } else {
                tempMax = root.leftNode.rightMaxDep;
            }

            root.leftMaxDep = tempMax + 1;
        }

        /**
         * 获得右子节点最大深度
         */
        if (root.rightNode != null) {

            int tempMax = 0;
            if (root.rightNode.leftMaxDep > root.rightNode.rightMaxDep) {
                tempMax = root.rightNode.leftMaxDep;
            } else {
                tempMax = root.rightNode.rightMaxDep;
            }

            root.rightMaxDep = tempMax + 1;
        }

        if (root.leftMaxDep + root.rightMaxDep > maxDis) {
            maxDis = root.leftMaxDep + root.rightMaxDep;
        }

    }


    @Test
    public void testFalse() {

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
        l6.leftNode=l71;
        TreeNode l62 = new TreeNode();
        l62.rightNode=l72;
        TreeNode l5 = new TreeNode();
        l5.leftNode = l6;
        TreeNode l52 = new TreeNode();
        l52.rightNode=l62;
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

        FindMaxDis(root);


        System.out.println(maxDis);


    }


}
