package com.yasin.spring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author yangzhenkun
 * @create 2019-03-11 11:19
 */
public class CSAfterMethod implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

        System.out.println("CSAfterMethod: after method");
    }
}
