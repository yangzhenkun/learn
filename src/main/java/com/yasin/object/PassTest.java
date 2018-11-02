package com.yasin.object;

import com.yasin.common.entity.Person;
import org.junit.Test;

/**
 * @author yangzhenkun
 * @create 2018-10-23 10:43
 */
public class PassTest {


    @Test
    public void start(){

        Person person = new Person(1L,"old");
        set(person);


        System.out.println(person);

    }


    private void set(Person person){

        person.setName("new");
        person.setId(2L);

    }


    @Test
    public void type(){

        Integer i = 124;

        typeSet(i);

        System.out.println(i);
    }


    private void typeSet(Integer i){
        i=123;

    }


}
