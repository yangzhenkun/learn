package com.yasin.spring.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author yangzhenkun
 * @create 2019-03-11 11:47
 */
//@Aspect
@Component
public class LoggingAspect {

    //    @Before("execution(* com.yasin.spring.aspect.CustomerBoImpl.addCustomer(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("logbefore is running");
        System.out.println(joinPoint.getSignature().getName());


        System.out.println("******");
    }

//    @Around("execution(* com.yasin.spring.aspect.CustomerBoImpl.addCustomerReturnValue(..))")
    public Object logAround(ProceedingJoinPoint jp) throws Throwable {

        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method realMethod = getDeclaredMethod(jp.getTarget().getClass(), signature.getName(), signature.getMethod().getParameterTypes());

        System.out.println("****\nlogAround() is running! " + signature.getName());
        Log log = signature.getMethod().getAnnotation(Log.class);
        if (log == null) {
            log = realMethod.getAnnotation(Log.class);
        }


        if (log != null) {
            System.out.println("我要打印日志");
        }

//        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

//        System.out.println("Around before is running!");
        Object obj = jp.proceed();
//        System.out.println("Around after is running!");

//        System.out.println("******");

        System.out.println("logAround() is end!\n******");
        return obj;
    }

    public Method getDeclaredMethod(Class clazz, String methodName, Class<?>... parameterTypes) {
        Method method = null;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            } catch (Exception e) {
                //这里什么都不做，找不到方法则继续去父类找
            }
        }
        return null;
    }
}
