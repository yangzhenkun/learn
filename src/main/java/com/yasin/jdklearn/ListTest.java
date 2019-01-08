package com.yasin.jdklearn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhenkun
 * @create 2018-12-25 14:32
 */
public class ListTest {


    @Test
    public void subTest() {

        List<String> data = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            data.add(String.valueOf(i));
        }


        System.out.println(JSON.toJSONString(data.subList(12,18)));


    }


}
