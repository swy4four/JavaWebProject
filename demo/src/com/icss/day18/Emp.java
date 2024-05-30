package com.icss.day18;
import java.io.Serializable;
/**
 * 遵循 javabean / java实体类规范
 *
 * 属性私有
 * 提供公有的get/set
 * 提供无参的构造方法
 * */
public class Emp implements Serializable{
    private String id;
    private String name;
    private String password;
    private String jobTitle;
    public Emp(){

    }

    public Emp(String id, String name, String password, String jobTitle) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.jobTitle = jobTitle;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
