package com.yasin.gc;

import com.yasin.common.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhenkun
 * @create 2018-10-24 19:02
 */
public class ContGC {


    @Test
    public void start() {

        List<Person> personList = new ArrayList<>(10);

        for (; ; ) {

            Person person = new Person();
            personList.add(new Person());
            personList.remove(person);

        }


    }


}
