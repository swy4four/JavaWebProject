package com.practise.pra03;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> list =new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("hahahha");

        System.out.println("第一种");
        // for each 遍历 List
        for(String str:list){
            System.out.println(str);
        }

        // 把链表变为数组相关的内容进行遍历
        String[] strArray=new String[list.size()];
        list.toArray(strArray);
        System.out.println("第二种");
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }

        //第三种遍历 使用迭代器
        Iterator<String> ite = list.iterator();
        System.out.println("第三种");
        while(ite.hasNext()){//判断下一个元素之后有值
            System.out.println(ite.next());
        }
    }
}
