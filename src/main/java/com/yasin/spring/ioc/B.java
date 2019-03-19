package com.yasin.spring.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangzhenkun
 * @create 2019-03-19 19:45
 */
@Data
@Component
public class B {

    @Autowired
    private C c;

}
