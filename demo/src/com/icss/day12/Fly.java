package com.icss.day12;

import java.io.Serializable;

/*
* Fly接口
* 接口与接口之间是多继承关系
* */
public interface Fly extends Serializable,Comparable {
    //接口中的变量都是公有静态变量
    int i=100;

    //接口中没有构造方法
    //接口中的方法默认都是抽象方法
    public abstract  void a();
    //接口中的abstract关键字可以省略
    public void b();
    //接口中的默认方法的访问权限都是public
    void c();

    //jdk1.7 之后 接口中补充了 static 修饰的方法 和 default 修饰方法

    public static void d(){
        System.out.println("ddddd");
    }
    default void e(){
        System.out.println("eeeee");
    }
}
