package com.icss.day09;

import com.icss.day08.Emp;
/**
 * 数组
 *
 * @author rose
 */
public class TestArray {
    public static void main(String[] args) {
        //数组对象创建  引用 和基本数据类型 在栈
        String[] a;//a 为数组名
        a = new String[5];// 数组元素的赋值 放在堆里

        // 数组中存储的是元素
        //数组元素的赋值
        a[0] = "hello1";
        a[1] = "hello2";
        a[2] = "hello3";
        // a[3]="hello4";
        // 数组下标 越界 ArrayIndexOutOfBoundsException

        System.out.println("数组长度：" + a.length);
        //System.out.println(a[0]);
        //数组的遍历
        for (int i = 0; i < 3; i++) {
            System.out.println(a[i]);
        }

        /*//引用类型数组
        Emp e1 = new Emp("张三1", 20, 50000);
        Emp e2 = new Emp("张三2", 20, 50000);
        Emp e3 = new Emp("张三3", 20, 50000);
        Emp e4 = new Emp("张三4", 20, 50000);

        Emp[] emps = new Emp[4];
        emps[0]=e1;
        emps[1]=e2;
        emps[2]=e3;
        emps[3]=e4;

        for (Emp emp:emps
             ) {
            System.out.println(emp);

        }*/
    }
}
