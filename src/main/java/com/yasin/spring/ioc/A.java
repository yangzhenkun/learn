package com.yasin.spring.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangzhenkun
 * @create 2019-03-19 19:44
 */
@Data
@Component
public class A {
    /**
     * 循环依赖问题，只是在fied中声明是后置，没有问题，如果在构造器中就会报错
     */

//    public A(B b){
//        this.b=b;
//    }

    @Autowired
    private B b;

}
