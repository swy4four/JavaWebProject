package com.chinasoft.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component("dbconnection")
@PropertySource("classpath:db.properties")
public class DBConnection {
    @Value("这个是数据库连接对象")
    private String details;

    @Value("${mysql.driver}:defaultdriver")
    private String driver;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.username}")
    private String username;
    @Value("${password}")
    private String password;

    @Value("${constants.test.other}.split('.')")
    private String s;

    @Value("#{10*20}")
    private  int age;
    @Value("#{T(java.lang.Math).random()}")
    private double rand;

    //读取系统属性
    @Value("#{systemProperties['user.country'] }")
    private String defaultLocale;

    @Value("#{systemProperties['user.timezone'] }")
    private String defaultTime;


    @Value("#{'${test.list}'.split(',')}")
    private List<String> list;

    //数组
    @Value("${myValues.array}")
    private String[] myValuesArray;

    //list集合
    @Value("${myValues.array}")
    private List<String> my;

    //Map
    @Value("#{${myValues.map}}")
    private Map<String, String> myValuesMap;

    public void a(@Value("@value可以绑定参数") String a){
        System.out.println(a);
    }
}
