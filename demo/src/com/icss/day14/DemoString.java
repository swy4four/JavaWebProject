package com.icss.day14;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

/**
 * 字符串处理类常用方法
 * */
public class DemoString {
    public static void main(String[] args) {
        String str =new String("abcdefg");
        //实际创造了两个字符串，一个在GC区 一个在永久区常量池

        boolean b=str.contains("aa");
        //如果并且只有当此字符串包含指定的字符序列的字符串值，则返回真值

        //System.out.println(b);

        int index= str.indexOf("cc");
        //返回指数在这个字符串指定的子字符串中第一个出现的。
        System.out.println("index = " + index);

        int i =str.codePointAt(0);
        System.out.println("i = " + i);//返回字符（Unicode代码点）在指定的索引

        System.out.println("abc".compareTo("bcd")); //比较两个字符串的Unicode码大小

        boolean b1=str.endsWith("gg");//测试此字符串是否以指定的后缀结束
        System.out.println(b1);
        System.out.println("abc".equals("Abc"));//将此字符串与指定对象比较
        System.out.println("abc".equalsIgnoreCase("Abc"));
        byte[] bs=str.getBytes();
        System.out.println(Arrays.toString(bs));


        str="abcdefabcdefabcdef";
       // index=str.indexOf("cd",5);//返回此字符串的指定子字符串出现再索引中 从指定 索引处开始

        index=str.lastIndexOf("3",5);
        System.out.println(index);

        str =str.replace("cd","mj");

        System.out.println(str);

        String str1="a,b,c,d";
        String[] ss =str1.split(",");//将此字符串再给定的regular expression 裁剪为数组
        for (String string:ss
             ) {
            System.out.println(string);
        }

        System.out.println(String.join("&","username=tom","password=1223344","age=20"));

        String phone ="12432453";
        System.out.println(phone.startsWith("43"));

        char[] ps=phone.toCharArray();
        for (char c:ps
             ) {
            System.out.println(c+",");
        }

        System.out.println();
        System.out.println("aBc".toUpperCase());//全部字符转大写
        System.out.println("aBc".toLowerCase());//全部字符转小写

        System.out.println(" abc ".trim().length());//去除收尾空格

        System.out.println("abc".trim().equals("abc"));

        String str2 ="abcdefgmjj";
        System.out.println(str2.substring(2,6));//字符串从指定的beginIndex延伸在指数endIndex -1 特征
    }
}
