package com.yasin.jdklearn.reflectlearn;

import java.util.HashMap;
import java.util.Map;

public class BLL {
	
	
	public Map<String,Object> bll(VO vo){
		
		Map<String,Object> map = new HashMap<>();
		map.put("int", vo.getI());
		map.put("string", vo.getS());
		return map;
	}

}
