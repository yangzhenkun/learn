package com.yasin.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangzhenkun01
 * @Date: 2019/2/23
 */
public class BinaryTreePath257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> ans = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {

        if(root==null){
            return new ArrayList();
        }

        bl(root,"");


        return ans;
    }

    public void bl(TreeNode root,String string){

        if(root!=null){
            string +=(root.val);

            if(root.left==null&&root.right==null){
                ans.add(string);
            }else{
                if(root.left!=null){
                    bl(root.left,string+"->");
                }
                if(root.right!=null){
                    bl(root.right,string+"->");
                }
            }
        }
    }

}
