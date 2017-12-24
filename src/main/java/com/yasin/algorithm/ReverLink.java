package com.yasin.algorithm;

public class ReverLink {

	
	public static void main(String[] args){
		
		
		Node<String> head = new Node<String>();
		head.data="1";
		Node<String> temp = new Node<String>();
		temp=head;
		for(int i=2;i<5;i++){
			Node<String> node = new Node<String>();
			node.data=i+"";
			temp.next=node;
			temp=node;
		}
		
		
		
		
		Node<String> pres = null;

		while(head.next!=null){
			
			temp=head;
			
			head=head.next;
			
			temp.next=pres;
			
			pres=temp;
			
		}
		
		head.next=pres;
		
		
		while(head!=null){
			System.out.println(head.data);
			head=head.next;
		}
		
	}
	
	static class Node<T>{
		T data;
		Node next;
		
	}
	
}
