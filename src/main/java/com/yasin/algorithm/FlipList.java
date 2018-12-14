package com.yasin.algorithm;

import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2018-12-14 14:48
 */
public class FlipList {

    class Node<T> {

        public T data;
        public Node next;

    }


    @Test
    public void flipList() {
        /**
         * init
         */
        Node head = null;
        Node cur = null;
        for (int i = 1; i <= 10; i++) {
            Node node = new Node();
            node.data = i;

            if (cur == null) {
                head = node;
            } else {
                cur.next = node;
            }
            cur = node;
        }

        /**
         * flip
         */
        Node pre = null;
        cur = head;
        Node next = cur.next;

        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }

        /**
         * ergodic
         */
        head=pre;
        cur=head;

        while(cur!=null){
            System.out.println(cur.data);
            cur=cur.next;
        }

    }

}
