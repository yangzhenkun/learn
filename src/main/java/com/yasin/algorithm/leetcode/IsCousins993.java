package com.yasin.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangzhenkun
 * @create 2019-03-05 17:21
 */
public class IsCousins993 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null) {
            return false;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(root);
        int count = 0;
        boolean isBor = false;
        while (!q1.isEmpty()) {
            count = 0;
            while (!q1.isEmpty()) {

                TreeNode cur = q1.poll();
                isBor = false;
                if (cur.left != null) {
                    if (cur.left.val == x || cur.left.val == y) {
                        count++;
                        isBor = true;
                    } else {
                        ((LinkedList<TreeNode>) q2).add(cur.left);
                    }
                }
                if (cur.right != null) {
                    if ((cur.right.val == x || cur.right.val == y)) {
                        if (isBor) {
                            return false;
                        }
                        count++;
                    } else {
                        ((LinkedList<TreeNode>) q2).add(cur.right);
                    }
                }

            }
            if(count==2){
                return true;
            }

            while (!q2.isEmpty()){
                ((LinkedList<TreeNode>) q1).add(q2.poll());
            }

        }


        return false;
    }


}
