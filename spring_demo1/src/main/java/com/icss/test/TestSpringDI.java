package com.icss.test;

import com.icss.bean.Driver;
import com.icss.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringDI {

    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Person person1 = (Person) ac.getBean("p1");
        Person person2 = (Person) ac.getBean("p1");

        System.out.println(person1);
        System.out.println(person1 == person2);

    }

    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");

        Driver driver=(Driver) ac.getBean("driver1");
        System.out.println(driver);
    }


}