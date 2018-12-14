package com.yasin.jdklearn.JavaLearn;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这是一个类级别的注释，这个注释中有一个name字段，默认值是  yasin
 * @author yasin
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Learn {
	String name() default "yasin";
}
