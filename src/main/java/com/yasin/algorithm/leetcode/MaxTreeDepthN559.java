package com.yasin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhenkun
 * @create 2019-02-22 15:35
 */
public class MaxTreeDepthN559 {

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


    public int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        if(root.children!=null){
            List<Integer> list = new ArrayList<>();

            for (Node child : root.children) {
                list.add(maxDepth(child));
            }

            return (max(list)+1);
        }


        return 1;

    }

    public int max(List<Integer> list) {

        if (list == null) {
            return 0;
        }

        int max = 0;
        for (Integer integer : list) {

            if (integer > max) {
                max = integer;
            }

        }

        return max;
    }

}
