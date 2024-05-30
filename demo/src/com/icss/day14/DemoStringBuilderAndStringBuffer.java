package com.icss.day14;

public class DemoStringBuilderAndStringBuffer {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("hello");
        sb.append("你好");
        sb.append("nice");

        System.out.println(sb.toString());
        sb.delete(2,7);//删除字符再字符串序列分析

        System.out.println(sb.toString());

        /*String s=new String("hello");
        s.concat("你好");
        s.concat("nice");
        System.out.println(s);*/
    }
}
