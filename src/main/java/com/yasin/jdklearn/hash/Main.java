package com.yasin.jdklearn.hash;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class Main {

	@Test
	public void run(){

		String data = "1544671096000";

		String timeMd5 = DigestUtils.md5Hex(data);


		System.out.println(timeMd5);

		
	}
	
}
