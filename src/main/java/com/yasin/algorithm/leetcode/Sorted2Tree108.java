package com.yasin.algorithm.leetcode;

/**
 * @author yangzhenkun
 * @create 2019-02-22 16:01
 */
public class Sorted2Tree108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {

        return build(nums, 0, nums.length - 1);

    }

    public TreeNode build(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        if (mid > l) {
            root.left = build(nums, l, mid - 1);
        }
        if (mid < r) {
            root.right = build(nums, mid + 1, r);
        }

        return root;
    }


}
