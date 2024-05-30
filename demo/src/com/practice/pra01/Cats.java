package com.practice.pra01;


/**
 * Cat子类
 * Animal 父类
 */
public class Cats extends Animal{

    public Cats() {
    }

    public Cats(String name, String variety, int age, String food) {
        super(name, variety, age, food);
    }

    public Cats(String name, int age) {
        super(name, age);
    }

    @Override
    public void barking() {
//        super.barking();
        System.out.println("喵喵喵");
    }
}
