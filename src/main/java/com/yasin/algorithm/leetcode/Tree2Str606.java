package com.yasin.algorithm.leetcode;

/**
 * @author yangzhenkun
 * @create 2019-02-27 15:00
 */
public class Tree2Str606 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode t) {

        core(t, false);
        if (sb.length() != 0) {

            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public void core(TreeNode t, boolean isLeft) {
        if (t == null) {
            if (isLeft) {
                sb.append("()");
                return;
            }
            return;
        }

        sb.append("(").append(t.val);
        core(t.left, need(t));
        core(t.right, false);
        sb.append(")");
    }

    public boolean need(TreeNode t){
        if(t!=null&&t.left==null&&t.right!=null){
            return true;
        }
        return false;
    }

}
