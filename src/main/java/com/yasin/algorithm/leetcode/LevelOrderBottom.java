package com.yasin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author yangzhenkun
 * @create 2019-02-22 19:21
 */
public class LevelOrderBottom {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q1 = new LinkedBlockingDeque<>();
        Queue<TreeNode> q2 = new LinkedBlockingDeque<>();

        q1.add(root);
        List<List<Integer>> ans = new ArrayList<>();

        while (!q1.isEmpty()){
            List<Integer> l = new ArrayList<>();

            while (!q1.isEmpty()){
                TreeNode cnode = q1.poll();

                if(cnode.left!=null){
                    q2.add(cnode.left);
                }
                if(cnode.right!=null){
                    q2.add(cnode.right);
                }

                l.add(cnode.val);
            }

            ans.add(l);
            while (!q2.isEmpty()){
                q1.add(q2.poll());
            }

        }

        return revert(ans);
    }

    public List revert(List list){

        List newL = new ArrayList(list.size());

        for (int i = list.size()-1; i >=0; i--) {
            newL.add(list.get(i));
        }


        return newL;
    }


}
