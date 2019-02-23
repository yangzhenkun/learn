package com.yasin.algorithm.leetcode;

import com.yasin.algorithm.rbtree.Tree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 这题目是基于二叉搜索树，这样的话可以依据大小关系找到；
 * @see LowestCommonAncestor235#lowestCommonAncestor2()
 *
 * 如果是普通的树，可以现在二叉树中找到目标所在路径，进行比较即可.
 * @see LowestCommonAncestor235#lowestCommonAncestor(TreeNode, TreeNode, TreeNode)
 *
 *
 * @author: yangzhenkun01
 * @Date: 2019/2/23
 */
public class LowestCommonAncestor235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void run(){

        TreeNode t3 = new TreeNode(3);
        TreeNode t5 =new TreeNode(5);
        TreeNode t0 = new TreeNode(0);
        TreeNode t4 = new TreeNode(4);
        t4.left=t3;
        t4.right=t5;
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t2 = new TreeNode(2);
        t2.left=t0;
        t2.right=t4;
        TreeNode t8 = new TreeNode(8);
        t8.left=t7;
        t8.right=t9;
        TreeNode t6 = new TreeNode(6);
        t6.left=t2;
        t6.right=t8;


        TreeNode ans = lowestCommonAncestor(t6,t2,t8);

        System.out.println(ans.val);
    }

    /**
     * 利用搜索二叉树特性
     * 1.如果root的值在p，q之间，说明p，q的第一个交点肯定就是root
     * 2.如果p,q均大于root.val，那么问题就变成了在root的右儿子中找到这个交点，递归即可
     * 3.如果p,q均小于root.val，那么问题就变成了在root的左儿子中找到这个交点，递归即可
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){

        if(root==null){
            return null;
        }

        if((root.val-p.val)*(root.val-q.val)<=0){
            return root;
        }else if(root.val<p.val){
            return lowestCommonAncestor2(root.right,p,q);
        }else{
            return lowestCommonAncestor2(root.left,p,q);
        }

    }




    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> plist = new ArrayList<>();
        List<TreeNode> qlist = new ArrayList<>();
        bl(root,p);
        plist.addAll(path);
        path.clear();
        bl(root,q);
        qlist.addAll(path);

        for (int i = plist.size()-1; i >=0; i--) {

            if(qlist.contains(plist.get(i))){
                return plist.get(i);
            }

        }
        return null;
    }

    List<TreeNode> path = new ArrayList<>();

    public boolean bl(TreeNode root, TreeNode target) {

        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.val == target.val) {
            return true;
        } else {
            boolean lfind = bl(root.left, target);
            if (lfind) {
                return true;
            }
            boolean rfind = bl(root.right, target);
            if (rfind) {
                return true;
            }
            path.remove(root);
        }

        return false;
    }


}
