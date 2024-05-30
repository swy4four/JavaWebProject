package com.icss.day09;

/**
 * 求数组中的最大值 记录最大值的位置
 */
public class Practise04 {
    public static void main(String[] args) {
        int[] num = {1, 3, 5, 7, 8, 456};
        int maxIndex = -1;// 位置

        int max = num[0];//假设 数组中第一个数是最大值
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
                maxIndex = i;
            }
        }
        System.out.println("最大值是" + max+"位置："+(maxIndex+1));
    }

}

