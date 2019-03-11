package com.yasin.algorithm.leetcode;

/**
 * @author yangzhenkun
 * @create 2019-03-07 11:29
 */
public class DistributeCoins979 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int ans = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);
        ans += (Math.abs(l) + Math.abs(r));

        return root.val + l + r - 1;
    }

}
