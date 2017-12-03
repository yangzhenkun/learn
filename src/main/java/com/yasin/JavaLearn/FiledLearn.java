package com.yasin.JavaLearn;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这是一个变量级别的注解，注解中有一个字段name，默认值是field
 * @author yasin
 *
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FiledLearn {
	String name() default "field";
	
	
}
