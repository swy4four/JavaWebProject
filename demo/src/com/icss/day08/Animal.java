package com.icss.day08;

public class Animal {
    public void speak(){

    }
}

class Dog extends Animal{
    public void speak(){
        System.out.println("小狗会汪汪叫");
    }
    public void eat(){
        System.out.println("小狗会吃狗粮");
    }


}
class Cat extends Animal {
    public void speak() {
        System.out.println("小猫会喵喵叫");
    }

    public void sleep() {
        System.out.println("小猫会睡觉");
    }
}