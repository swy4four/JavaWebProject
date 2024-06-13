package com.icss.test;

import com.chinasoft.bean.DBConnection;
import com.icss.bean.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOC {
    @Test
    public  void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc/spring.xml");
        Employee e1 = (Employee) ac.getBean("emp");
        System.out.println(e1);

        Employee e2 = (Employee) ac.getBean("emp");
        System.out.println(e2);

        System.out.println(e1 == e2);
    }

    /**
     * 测试@value的用法
     */
    @Test
    public  void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("ioc/spring.xml");
        DBConnection db = (DBConnection) ac.getBean("dbconnection");
        db.a(null);
        System.out.println(db);
    }
}
