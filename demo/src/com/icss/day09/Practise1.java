package com.icss.day09;

import java.util.Arrays;

/**
 * 声明一个 char 数组 存放 元素为0-9 ‘A-Z’ ‘a-z’
 */
public class Practise1 {
    public static void main(String[] args) {
        int size = 62;
        char[] arr = new char[size];

        for (int i = 0; i < arr.length; i++) {
            if (i < 10) {
                arr[i] = (char) ('0' + i);
            } else if (i >=10&&i< 36) {
                arr[i] = (char) ('A' + i - 10);
            } else {
                arr[i] = (char) ('a' + i - 36);
            }
        }
        //System.out.println(Arrays.toString(arr));

        //普通 for 循环遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //增强性for循环
        System.out.println("-----------");
        int index =0;
        for (char c: arr) {
            System.out.println(c+","+index ++);
        }
    }
}
