package com.yasin.algorithm.leetcode;

import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2019-02-27 15:17
 */
public class PathSum437 {

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

        TreeNode t3 = build(3, null, null);
        TreeNode t_2 = build(-2, null, null);
        TreeNode t1 = build(1, null, null);
        TreeNode t32 = build(3, t3, t_2);
        TreeNode t2 = build(2, null, t1);
        TreeNode t11 = build(11, null, null);
        TreeNode t5 = build(5, t32, t2);
        TreeNode t_3 = build(-3, null, t11);
        TreeNode t10 = build(10, t5, t_3);


        System.out.println(pathSum(t10,8));

    }

    public TreeNode build(int value, TreeNode left, TreeNode right) {

        TreeNode root = new TreeNode(value);
        root.left = left;
        root.right = right;
        return root;
    }


    int ans = 0;
    int sum = 0;

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        blAll(root);
        return ans;
    }

    public void blAll(TreeNode root) {

        if (root == null) {
            return;
        }
        core(root, 0);
        blAll(root.left);
        blAll(root.right);
    }

    public void core(TreeNode root, int pathSum) {

        if (root == null) {
            return;
        }
        pathSum += root.val;

        if (pathSum == sum) {
            ans++;
        }
        core(root.left, pathSum);
        core(root.right, pathSum);

        pathSum -= root.val;
    }

}
