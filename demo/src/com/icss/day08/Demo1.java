package com.icss.day08;

public class Demo1 {
    public static void main(String[] args) {
        Animal a = new Dog();
        new Demo1().b(a);
    }

    public void b(Animal a) {
        //判断小猫还是小狗
        //说明如何叫
        //如果小狗调用 eat 方法
        // 如果小猫 调用 sleep方法
        a.speak();
        //System.out.println(a instanceof Dog );// instanceof 用来判断 对象类型
        if (a instanceof Dog) {
            ((Dog) a).eat();

        } else {
            ((Cat) a).sleep();
        }
    }
}
