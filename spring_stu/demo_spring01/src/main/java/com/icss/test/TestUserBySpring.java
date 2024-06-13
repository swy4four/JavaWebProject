package com.icss.test;

import com.icss.config.XMLconfig;
import com.icss.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


//@ExtendWith(SpringExtension.class)//等于@SpringJUnitConfig
@SpringJUnitConfig
@ContextConfiguration(classes=XMLconfig.class)

public class TestUserBySpring {
   /* @Resource(name = "usi")*/
    @Autowired
    @Qualifier("usi")
    private UserService userService;

    @Test
    public void  test1(){
        System.out.println(userService.getUser());
    }

    @Test
    public void  test2(){
        System.out.println(userService);
        System.out.println(userService.getAllUsers());
    }

    /*@Test
    public void  test3(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("user_spring.xml");
        UserService userService = (UserService) ac.getBean("usi");
        System.out.println(userService);
        System.out.println(userService.getAllUsers());

    }
*/
}
