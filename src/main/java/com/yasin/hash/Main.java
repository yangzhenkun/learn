package com.yasin.hash;

import org.junit.Test;

import com.yasin.common.entity.Person;

public class Main {

	@Test
	public void run(){
		
		Person p1 = new Person(1l,"zs");
		Person p2 = new Person(1l,"zs");
		
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		
	}
	
}
