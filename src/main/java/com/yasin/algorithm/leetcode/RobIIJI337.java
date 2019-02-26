package com.yasin.algorithm.leetcode;

/**
 * @author yangzhenkun
 * @create 2019-02-25 09:52
 */
public class RobIIJI337 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 如果打算抢这个节点，那么它的左右儿子肯定不能抢的
     *
     * @param root
     * @return
     */
    public int robin(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return (robout(root.left) + robout(root.right) + root.val);
    }

    /**
     * 如果不打算抢这个点，那么获取左右儿子的最优值，虽然这个点不抢，所以左右儿子也不一定抢，直接获取他们的最优策略即可。
     *
     * @param root
     * @return
     */
    public int robout(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return (rob(root.left)+rob(root.right));
    }


    public int rob(TreeNode root) {
        return Math.max(robin(root),robout(root));
    }


}
