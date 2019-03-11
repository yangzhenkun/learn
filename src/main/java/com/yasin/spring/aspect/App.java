package com.yasin.spring.aspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yangzhenkun
 * @create 2019-03-11 11:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app_aspect.xml"})
public class App {

    @Autowired
    CustomerBo customerBo;

    @Test
    public void run() {

        customerBo.addCustomer();

        System.out.println(customerBo.addCustomerReturnValue());

    }
}
