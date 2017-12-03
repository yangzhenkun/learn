package com.yasin.enumLearn;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class Main {
	
	@Test
	public void main(){

//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		formatter = formatter.withLocale(Locale.CHINESE);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
//		LocalDate date = LocalDate.parse("2005-09-12", formatter);		
//		
//		LocalDate now = LocalDate.now();
//		
//		
//		System.out.println(now.plusMonths(-1).format(formatter));
//		
//		System.out.println(KeyEnum.id.getName());
		
		
		Integer i = new Integer(1);
		Integer i2 = new Integer(1);
		System.out.println(i==i2);
		
		
		
	}

}
