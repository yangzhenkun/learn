package com.yasin.algorithm.leetcode;

import org.junit.Test;

/**
 * 最大二叉树
 *
 * @author yangzhenkun
 * @create 2019-02-22 10:40
 */
public class MaxTree654 {


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

        int[] nums = {3, 2, 1, 6, 0, 5};

        TreeNode root = constructMaximumBinaryTree(nums);


        System.out.println(root);


    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {

        int index = maxIndex(nums, start, end);
        TreeNode root = null;

        if (index != -1) {
            root = new TreeNode(nums[index]);

            root.left = build(nums, start, index - 1);
            root.right = build(nums, index + 1, end);

        }


        return root;
    }


    public int maxIndex(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {

            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }

        }

        return index;
    }


}
