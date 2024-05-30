package com.icss.day10.student;
/**
 * student 类
 * */
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Student {
    private String name; //姓名
    private char gender; //性别
    private int age;// 年龄
    private String phone; // 电话
    private String email; // email

    public Student(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
