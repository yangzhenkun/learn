package com.yasin.algorithm.leetcode;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * leetcode 226
 *
 * @author yangzhenkun
 * @create 2019-01-03 17:29
 */
public class InvertBinaryTree226 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Queue<TreeNode> queue = new ArrayDeque<>();

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        queue.add(root);
        while (!queue.isEmpty()) {

            TreeNode cur = queue.remove();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }

            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

        }

        return root;

    }


    @Test
    public void testD() {

        TreeNode t41 = new TreeNode(41);
        TreeNode t42 = new TreeNode(42);

        TreeNode t31 = new TreeNode(31);
        t31.left = t41;

        TreeNode t32 = new TreeNode(32);
        TreeNode t33 = new TreeNode(33);
        t33.right = t42;

        TreeNode t21 = new TreeNode(21);
        t21.left = t31;

        TreeNode t22 = new TreeNode(22);
        t22.left = t32;
        t22.right = t33;

        TreeNode t11 = new TreeNode(11);
        t11.left = t21;
        t11.right = t22;


        invertTree(t11);


        System.out.println(t11);
    }


    public int maxSubArray(int prices[]) {

        int minPrice = Integer.MAX_VALUE;
        int res = 0;

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;
            } else {
                int temp = price - minPrice;
                if (temp > res) {
                    res = temp;
                }

            }

        }

        return res;

    }

    public int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int res = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {

            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i + 1] < prices[i]) {
                res += (prices[i] - buy);
                buy = Integer.MAX_VALUE;
            }
        }
        if (prices[prices.length - 1] >= prices[prices.length - 2]) {
            res += (prices[prices.length - 1] - buy);
        }

        return res;
    }


    public int climbStairs(int m, int n) {
        if (n < m) {
            int t = n;
            n = m;
            m = t;
        }


        System.out.println(jc(n));

        System.out.println(jc(n - m));


        System.out.println(jc(m));

        return (int) (jc(n) / jc(n - m) / jc(m));
    }

    public long jc(int n) {

        long res = 1;
        for (long i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    public BigInteger A(int n, int m) {
        BigInteger res = new BigInteger("1");
        // 循环m次,如A(6,2)需要循环2次，6*5
        for (int i = m; i > 0; i--) {
            res = res.multiply(new BigInteger(String.valueOf(n)));
            n--;// 下一次减一
        }
        return res;
    }

    public int C(int n, int m)// 应用组合数的互补率简化计算量
    {
        int helf = n / 2;
        if (m > helf) {
            m = n - m;
        }
        // 分子的排列数
        BigInteger numerator = A(n, m);
        // 分母的排列数
        BigInteger denominator = A(m, m);


        System.out.println(numerator.divide(denominator).longValue());

        return numerator.divide(denominator).intValue();
    }

    @Test
    public void test() {

        System.out.println(C(51, 9));
    }


}
