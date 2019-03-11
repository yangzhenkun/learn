package com.yasin.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author yangzhenkun
 * @create 2019-03-11 11:21
 */
public class CSAroundMethod implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {


        System.out.println("start");

        Object result = methodInvocation.proceed();

        System.out.println("end");
        return result;
    }
}
