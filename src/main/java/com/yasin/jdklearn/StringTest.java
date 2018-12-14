package com.yasin.jdklearn;

import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2018-11-30 18:02
 */
public class StringTest {


    @Test
    public void testdd(){

        String data = "1"+"2"+"3";

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("1").append("2").append("3");

        String d = stringBuilder.toString();


        System.out.println(data);

        System.out.println(d);
    }

}
