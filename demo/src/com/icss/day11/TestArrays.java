package com.icss.day11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * arrays 是数组工具类
 */
public class TestArrays {
    public static void main(String[] args) {
        Integer[] is = {1, 9, 5, 6, 7, 9, 8};
        //Arrays.sort(is);默认排序
        Arrays.sort(is, Comparator.reverseOrder());// 倒序 
        for (int i : is) {
            System.out.println(i);
        }
    }
}
