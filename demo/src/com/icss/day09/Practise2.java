package com.icss.day09;

import com.icss.day08.Emp;

import java.util.Arrays;

public class Practise2 {
    public static void main(String[] args) {

    /*//引用 类型的数组
    Emp e1 = new Emp("张三1", 20, 50000);
    Emp e2 = new Emp("张三2", 20, 50000);
    Emp e3 = new Emp("张三3", 20, 50000);
    Emp e4 = new Emp("张三4", 20, 50000);

    Emp[] emps = new Emp[] {e1, e2, e3, e4};

        for (Emp emp:emps) {
            System.out.println(emp);
    }*/

        // 字面量形式数组
        Emp[] emps = {new Emp("张三", 20, 20000), new Emp("张三2", 20, 20000), new Emp("张三3", 20, 20000)};

   /* for (Emp emp:emps){
        System.out.println(emp);
    }*/

        System.out.println(Arrays.toString(emps));
        int [] is ={1,2,3,4,6};
        for (int i:is){
            System.out.println(i);
        }

    }

}