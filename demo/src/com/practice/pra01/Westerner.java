package com.practice.pra01;
//实现接口

//类中的方法我们可以叫重写
//接口：实现
public class Westerner implements Human{
    @Override
    public void eat() {
        System.out.println("吃西餐");
    }

    @Override
    public void run() {
        System.out.println("大步跑");
    }
}
