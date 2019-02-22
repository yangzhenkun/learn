package com.yasin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author yangzhenkun
 * @create 2019-02-22 18:46
 */
public class NTreeLevel429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {

        if(root==null){
            return new ArrayList<>();
        }

        Queue<Node> q1 = new LinkedBlockingDeque<>();
        Queue<Node> q2 = new LinkedBlockingDeque<>();

        List<List<Integer>> ans = new ArrayList<>();

        q1.add(root);

        while (!q1.isEmpty()) {

            List<Integer> l = new ArrayList<>();

            while (!q1.isEmpty()) {

                Node cnode = q1.poll();
                l.add(cnode.val);

                if (cnode.children != null) {
                    for (Node child : cnode.children) {
                        q2.add(child);
                    }
                }

            }

            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }

            ans.add(l);
        }


        return ans;
    }


}
