package com.icss.test;


import com.icss.bean.Phone;
import com.icss.bean.User;
import com.icss.config.XMLCreateBean;
import com.icss.config.XMLconfig;
import com.icss.dao.UserDao;
import com.icss.dao.UserDaoImpl;
import com.icss.service.UserService;
import com.icss.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    //基于配置文件(xml)
    @Test
    public void getAllUser1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("user_spring.xml");
        UserService userService = (UserService) ac.getBean("usi");
        System.out.println(userService.getAllUsers());
    }
    //基于配置类1
    @Test
    public void getAllUser2(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(XMLconfig.class);
        UserService userService = (UserService) ac.getBean(UserServiceImpl.class);
        //UserService userService = (UserService) ac.getBean("usi");
        System.out.println(userService.getAllUsers());
    }

    //基于配置类
    @Test
    public void TestXMLCreateBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(XMLCreateBean.class);
        User user = (User) ac.getBean("user1");
        System.out.println(user);
    }


    @Test
    public void testPhone(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("user_spring.xml");
        Phone phone = (Phone) ac.getBean("phone");
       // phone.setPrice(3000);
        System.out.println(phone);
    }

}
