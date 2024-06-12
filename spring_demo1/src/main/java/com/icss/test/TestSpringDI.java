package com.icss.test;

import com.icss.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDI {

    @Test
    public void testDi() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Person person1 = (Person) ac.getBean("p1");
        Person person2 = (Person) ac.getBean("p1");

        System.out.println(person1);
        System.out.println(person1 == person2);

    }
}