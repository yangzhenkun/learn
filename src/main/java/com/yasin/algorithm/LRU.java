package com.yasin.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 最近最少使用淘汰算法实现
 * 
 * 这种算法应用于  认为最近访问的数据即在未来被访问的概率较高的背景下 
 * 
 * 通过维护一个双向链表，来快速的增加，淘汰，移动到队首操作
 * 
 * @author yangzhenkun
 *
 */
public class LRU {

	private Map<String,Node> cache = new HashMap<>();
	
	private int count = 0;
	private int capacity = 20;
	private Node head,tail;
	
	public LRU(int capacity){
		this.capacity=capacity;
		
		head = new Node();
		head.pre=null;
		tail = new Node();
		tail.pre=head;
		tail.next=null;
		head.next=tail;
		
	}
	
	public Object get(String key){
		
		Node node = cache.get(key);
		if(node==null){
			return null;
		}else{
			move2Head(node);
			return node.value;
		}
		
	}
	
	public void set(String key,Object value){
		Node node = new Node();
		node.key=key;
		node.value=value;
		cache.put(key, node);
		if(count==capacity){//已经达到最大值
			Node realTail = tail.pre;//获取真正最近没有使用的节点
			remove(realTail);
		}else{
			count++;
		}
		
		add(node);
	}
	
	private void move2Head(Node node){
		
		remove(node);
		add(node);
	}
	
	private void add(Node node){
		
		Node oldHead = head.next;
		node.pre=head;
		node.next=oldHead;
		head.next=node;
		oldHead.pre=node;
		
		cache.put(node.key, node);
	}
	
	private void remove(Node node){
		
		Node pre = node.pre;
		Node next = node.next;
		
		pre.next=next;
		next.pre=pre;
		
		node.next=null;
		node.pre=null;
		
		cache.remove(node.key);
	}
	
	
	private void addHead(Node node){
		
		node.next=head.next;
		node.pre=head;
		head.next=node;
		
		
	}
	
	
	
	public class Node{
		
		public String key;
		public Object value;
		public Node pre;
		public Node next;
	}
	
}
