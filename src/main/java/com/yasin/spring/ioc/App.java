package com.yasin.spring.ioc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yangzhenkun
 * @create 2019-03-11 11:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app.xml"})
public class App {

    @Autowired
    private A a;

    @Test
    public void run() {



        System.out.println(a.getB());
    }

}
