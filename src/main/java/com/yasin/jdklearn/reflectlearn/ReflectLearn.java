package com.yasin.jdklearn.reflectlearn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.junit.Test;

public class ReflectLearn {

	
	@Test
	public void test(){
		
		Class clazz = BLL.class;
		
		
		try {
			Object bll = clazz.newInstance();
			VO vo = new VO();
			vo.setI(1);
			vo.setS("H");
			
			Method m = clazz.getDeclaredMethod("bll",VO.class);
			Map<String,Object> map = (Map<String, Object>) m.invoke(bll,vo);
			System.out.println(map.get("int"));
			System.out.println(map.get("string"));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
