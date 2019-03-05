package com.yasin.algorithm;

import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2019-03-05 16:40
 */
public class QuickSortLink {

    class Node {

        Node next;
        Node pre;
        int value;

        Node(int value){
            this.value=value;
        }

        int length() {
            Node head = this;
            int length = 0;
            while (head != null) {
                length++;
                head = head.next;
            }

            return length;
        }

    }

    public Node get(Node head, int index) {

        int count = 0;
        while (head != null) {
            count++;
            if (count == index) {
                return head;
            } else {
                head = head.next;
            }

        }
        return null;
    }


    public void quickSort(Node head, int start, int end) {
        int left = start;
        int right = end;
        Node flagNode = get(head, start);
        Node sNode = flagNode;
        int flag = flagNode.value;
        Node eNode = get(head, end);

        while (left < right) {

            while (left < right && flag < eNode.value) {
                right--;
                eNode = eNode.pre;
            }
            if(left<right){
                sNode.value=eNode.value;
                sNode=sNode.next;
                left++;
            }
            while (left<right&&flag>sNode.value){
                left++;
                sNode=sNode.next;
            }
            if(left<right){
                eNode.value=sNode.value;
                eNode=eNode.pre;
                right--;
            }
        }

        get(head,left).value=flag;

        if(start<left-1){
            quickSort(head,start,left-1);
        }
        if(end>left+1){
            quickSort(head,left+1,end);
        }


    }

    public void bl(Node head){

        while (head!=null){

            System.out.println(head.value);
            head=head.next;
        }

        System.out.println("=================");

    }


    @Test
    public void run(){

        //1,8,3,6,5,4,7,2,9,0

        Node head = new Node(1);

        Node h8 = new Node(8);
        h8.pre=head;
        head.next=h8;

        Node h3 = new Node(3);
        h3.pre=h8;
        h8.next=h3;

        Node h6 = new Node(6);
        h6.pre=h3;
        h3.next=h6;

        Node h5 = new Node(5);
        h5.pre=h6;
        h6.next=h5;

        Node h4 = new Node(4);
        h4.pre=h5;
        h5.next=h4;

        Node h7 = new Node(7);
        h7.pre=h4;
        h4.next=h7;

        Node h2 = new Node(2);
        h2.pre=h7;
        h7.next=h2;

        Node h9 = new Node(9);
        h9.pre=h2;
        h2.next=h9;

        Node h0 = new Node(0);
        h0.pre=h9;
        h9.next=h0;

        quickSort(head,1,head.length());

        bl(head);

    }


}
