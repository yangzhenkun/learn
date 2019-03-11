package com.yasin.spring.aspect;

import org.springframework.stereotype.Service;

/**
 * @author yangzhenkun
 * @create 2019-03-11 11:45
 */
@Service
public class CustomerBoImpl implements CustomerBo {

    @Override
    @Log
    public void addCustomer() {

        System.out.println("addCustomer() is running");
    }

    @Override
    public String addCustomerReturnValue() {
        System.out.println("addCustomerReturnValue() is running ");
        return "abc";
    }

    @Override
    public void addCustomerThrowException() throws Exception {
        System.out.println("addCustomerThrowException() is running ");
        throw new Exception("Generic Error");
    }

    @Override
    public void addCustomerAround(String name) {
        System.out.println("addCustomerAround() is running, args : " + name);
    }
}
