package com.yasin.jdklearn.TransferParamInFun;

import com.yasin.jdklearn.extendsLearn.Parent;
import org.junit.Test;

public class Main {

    @Test
    public void run() {


        System.out.println(fun(null));
    }

    public int fun(Parent p) {

        try {
            return 1;
        } catch (Exception e) {

        } finally {
            System.out.println("finally");
            return 2;
        }

    }


}
