package com.yasin.spring.aop;

import lombok.Data;

/**
 * @author yangzhenkun
 * @create 2019-03-11 11:12
 */
@Data
public class CustomerService {

    private String name;
    private String url;

    public void printName() {
        System.out.println(name);
    }

}
