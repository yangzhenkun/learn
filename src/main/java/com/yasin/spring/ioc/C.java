package com.yasin.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangzhenkun
 * @create 2019-03-19 19:45
 */
@Component
public class C {

    @Autowired
    private A a;

}
