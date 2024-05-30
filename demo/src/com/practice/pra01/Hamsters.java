package com.practice.pra01;

//当一个类继承了一个抽象类时候，此时，该子类必须重写父类中的所有抽象方法
public class Hamsters extends Animal {
    //仓鼠

    @Override
    public void barking() {
        //super.barking();
        System.out.println("老鼠叫....");
    }
}