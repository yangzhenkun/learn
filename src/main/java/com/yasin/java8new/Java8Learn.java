package com.yasin.java8new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.net.SyslogAppender;
import org.junit.Test;



/**
 * java8 主要带来了两个新特性，一个是lambda表示是，一个是流式api
 * 
 * lambda表示式在代替匿名内部类是非常节省代码长度的，但并不能声明lambda风格的方法
 * 并且集合的流式操作并不是lambda
 * @author yasin
 */
public class Java8Learn {
	
	
	class A{
		long a;
	}

	@Test
	public void run(){

		A a = new A();
		System.out.println(a.a);
		
//		String a = "1;2;3;";
//		String[] as = a.split(";");
//		for(String t:as){
//			System.out.println(t);
//		}
		
		
		
		
		/*
		 * 对于匿名内部类的使用
		 */
//		new Thread(new Runnable(){
//
//			public void run() {
//				System.out.println("hello world");
//			}
//			
//			
//		}).start();
//		
//		
//		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
//		
//		
		
		/**
		 * 流式api
		 */
//		List<String> ss = Arrays.asList("1","2","3","4");
//		for(String s:ss){
//			System.out.println(s);
//		}
//		
//		ss.forEach(s->System.out.println(s));
		
		
//		List<Integer> costBeforeTax = Arrays.asList(100,200,300,400,500);
//		for(Integer cost:costBeforeTax){
//			double price=cost+0.12*cost;
//			System.out.println(price);
//		}
//		
//		costBeforeTax.forEach(cost -> System.out.println(cost));
//		
		
		
	}
	
	
	@Test
	public void stream(){
		
		Map<Integer,String> map;
		
		map = new HashMap<>();
		
		map.put(1, "11");
		map.put(2, "22");
		map.put(3, "33");
		
		Map<String,String> maps = new HashMap<>();
		maps.put("1", "11");
		maps.put("2", "22");
		maps.put("3", "33");
		
//		maps.keySet().stream().filter(s->s.equals("1")).forEach(s->System.out.println(maps.get(s)));
		
		
		List list = new ArrayList();
		for(int i=1;i<=5;i++)
			list.add(i);
		
		list.stream().filter(i->(int)i%2==1).forEach(System.out::println);
		
		/**
		 * 这是对Set的流式操作，
		 * 这是使用了filter这个中间操作
		 * 接着使用forEach这个最终操作
		 * forEach中是lambda表示操作
		 * 要是使用之前的语法就很麻烦
		 */
//		map.keySet().stream().filter(i->i%2==1).forEach(s->System.out.println(map.get(s)));
		
	}
	
	
	

}
