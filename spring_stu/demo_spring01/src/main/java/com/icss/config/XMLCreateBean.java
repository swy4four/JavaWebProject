package com.icss.config;

import com.icss.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class XMLCreateBean {

    @Bean(name="user1",initMethod = "init")
    @Scope("singleton")
    public User getUser(){
        return new User(100,"泽连斯基");
    }
}
