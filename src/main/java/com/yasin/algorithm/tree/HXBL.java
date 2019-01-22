package com.yasin.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找树中一个路径，等于一个目标值，并且打印出来
 * <p>
 * 递归就是跟栈的逻辑一样，以后碰到树的题，要考虑到 在递归结束后，这个节点下所有的点都 遍历了
 * <p>
 * 有了这个逻辑，对你处理树的算法有很多好处。
 *
 * @author yangzhenkun
 * @create 2019-01-22 15:10
 */
public class HXBL {

    List<TreeNode> path = new ArrayList<>();

    int des = 115;

    int temp = 0;

    class TreeNode {

        TreeNode(int value) {
            this.value = value;
        }

        TreeNode leftNode;
        TreeNode rightNode;

        int value;
    }


    public void bl(TreeNode node) {

        if (node == null)
            return;

        temp += node.value;
        path.add(node);

        if (node.leftNode == null && node.rightNode == null && temp == des) {
            path.forEach(p -> {
                System.out.println(p.value);
            });

            return;
        }

        bl(node.leftNode);
        bl(node.rightNode);

        temp -= node.value;
        path.remove(node);


    }


    @Test
    public void run() {

        TreeNode t41 = new TreeNode(4);
        TreeNode t42 = new TreeNode(9);
        TreeNode t43 = new TreeNode(11);
        TreeNode t44 = new TreeNode(16);
        TreeNode t45 = new TreeNode(25);
        TreeNode t46 = new TreeNode(31);
        TreeNode t47 = new TreeNode(45);
        TreeNode t48 = new TreeNode(55);

        TreeNode t31 = new TreeNode(7);
        TreeNode t32 = new TreeNode(15);
        TreeNode t33 = new TreeNode(30);
        TreeNode t34 = new TreeNode(50);

        TreeNode t21 = new TreeNode(10);
        TreeNode t22 = new TreeNode(40);

        TreeNode root = new TreeNode(20);

        root.leftNode = t21;
        root.rightNode = t22;

        t21.leftNode = t31;
        t21.rightNode = t32;
        t22.leftNode = t33;
        t22.rightNode = t34;

        t31.leftNode = t41;
        t31.rightNode = t42;
        t32.leftNode = t43;
        t32.rightNode = t44;
        t33.leftNode = t45;
        t33.rightNode = t46;
        t34.leftNode = t47;
        t34.rightNode = t48;

        bl(root);

    }

}
