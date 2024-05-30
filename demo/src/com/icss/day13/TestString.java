package com.icss.day13;

public class TestString {
    public static void main(String[] args) {
        //字面量字符串
        String str1="hello";
        String str2="hello";
        System.out.println(str1==str2);//true

        String str3=new String("hello");
        String str4=new String("hello");
        System.out.println(str3==str4);//比较内存地址//false

        System.out.println(str1.equals(str3));//单纯的比较字符串的值 就用equals
        //比较地址用==
    }
}
