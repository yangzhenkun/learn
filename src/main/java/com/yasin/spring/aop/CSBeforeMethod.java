package com.yasin.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author yangzhenkun
 * @create 2019-03-11 11:15
 */
public class CSBeforeMethod implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {


        System.out.println("CSBeforeMethod: Before method do!");
    }
}
