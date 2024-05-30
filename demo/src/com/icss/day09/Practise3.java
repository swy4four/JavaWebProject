package com.icss.day09;

import java.util.Scanner;

public class Practise3 {
    public static void main(String[] args) {
        // 在控制台 输入一个数字 判断数组中是否有这个数字 如果有 返回该数字在数组中的位置

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num = sc.nextInt();
        int[] is = {1, 3, 5, 7, 9};

        int index = -1;// 记录索引

        boolean temp = false;//开关变量
        for (int i = 0; i < is.length; i++) {
            if (num == is[i]) {
                //System.out.println(num + "存在");
                index = i;
                temp = true;
                break;
            }
            /* else {
                System.out.println(num + "不存在");
            }*/
            //  System.out.println(is[i]);
        }
        if (temp) {
            System.out.println(num + "存在," + "位置是" + (index + 1));
        } else {
            System.out.println(num + "不存在");
        }
    }
}
