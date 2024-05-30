package com.icss.day12;

import java.io.Serializable;
/*
* 接口与类之间的关系是实现关系，实现的关键字是implements 支持多继承
* */
//Plane 是实现类
public class Plane implements Fly, Serializable {

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public static void main(String[] args) {
        Fly.d();
        new Plane().e();

    }
    //new Fly();//接口不能创建对象
}
