package com.yasin.algorithm.leetcode;

import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2019-01-08 10:09
 */
public class InvertLink61 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (length == 0) {
            return head;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        ListNode newHead = head;
        //取要移动的头
        cur = head;
        int index = 0;
        while (cur != null) {
            index++;
            ListNode temp = cur;
            cur = cur.next;
            if (index == (length - k + 1)) {
                newHead = temp;
                break;
            } else if (index == (length - k)) {
                temp.next = null;
            }
        }

        cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }


    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        head.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;

        ListNode newHead = rotateRight(head, 4);

        bl(newHead);


    }


    private void bl(ListNode head) {

        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }

}
