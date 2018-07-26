package com.yasin.check;

import java.lang.reflect.Field;
import java.util.Objects;

import com.yasin.common.entity.Person;

public class CheckUtil {

	public static boolean checkFileNonNull(Object data) {

		for (Field f : data.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				/**
				 * 如果没有checkignore注解，并且字段为空，返回false
				 */
				if(Objects.isNull(f.getAnnotation(Check.class))&&Objects.isNull(f.get(data))) {
					return false;
				}
				
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return true;

	}
	
	
	public static void main(String[] args) {
		
		System.out.println(checkFileNonNull(new Person(1L,null)));
		System.out.println(checkFileNonNull(new Person(null,"dd")));

		
		
	}

}
