package com.yasin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yangzhenkun
 * @create 2019-02-22 14:15
 */
public class QianxuNTree589 {

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

    public List<Integer> preorderIeterator(Node root) {

        Stack<Node> flag = new Stack<>();
        Stack<Node> stack = new Stack<>();

        if (root != null) {

            flag.push(root);
            stack.push(root);

            while (!flag.isEmpty()) {

                Node node = flag.pop();

                if(node.children!=null){

                    int l = node.children.size()-1;


                    for (int i = l; i >=0; i--) {
                        stack.add(node.children.get(i));
                        flag.add(node.children.get(l-i));
                    }

                }

            }


        }

        while(!stack.isEmpty()){
            ans.add(stack.pop().val);
        }


        return ans;
    }


    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        if (root != null) {


            if (root.children != null) {

                for (Node child : root.children) {
                    preorder(child);
                }


            }
            ans.add(root.val);
        }


        return ans;
    }


}
