package com.yasin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: yangzhenkun01
 * @Date: 2019/2/23
 */
public class AverageOfLevels637 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q1 = new LinkedBlockingQueue<TreeNode>();
        Queue<TreeNode> q2 = new LinkedBlockingQueue<TreeNode>();

        q1.add(root);

        while (!q1.isEmpty()) {

            double sum = 0;
            int count = 0;

            while (!q1.isEmpty()) {
                TreeNode cnode = q1.poll();
                sum += cnode.val;
                count++;
                if (cnode.left != null) {
                    q2.add(cnode.left);
                }

                if (cnode.right != null) {
                    q2.add(cnode.right);
                }
            }

            ans.add(sum / count);
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }

        return ans;
    }

}
