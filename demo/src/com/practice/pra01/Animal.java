package com.practice.pra01;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Animal {

    //抽象类
    //public static String plot = "NanG";
    //fianl修饰变量 永远不能改了
    private static final String TEXT_COMMUNITY_NAME = "NanG";
    //名字
    private String name;

    //种类
    private String variety;

    //年龄
    private int age;

    //食物
    private String food;

    public Animal() {
    }

    //有参数构造函数
    public Animal(String name, String variety, int age, String food) {
        this.name = name;
        this.variety = variety;
        this.age = age;
        this.food = food;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //
    public void setAge(int age) {
        if (age < 0 || age > 30) {
            this.age = 0;
            //如果不加final plot 则能被修改 程序不合格
            //TEXT_COMMUNITY_NAME = "123";
            System.out.println("您输入的数据不合法，已经默认清零！");
        } else {
            this.age = age;
        }
    }

    public String getFood() {
        return food;
    }

    // 一个动作 方法（函数） 在类当中 有一个名字叫做---行为
    public void eat() {
        System.out.println(this.name + "正在吃饭..正在吃" + this.food);
    }

    //this.name 指调用对象
    public void sleep() {
        System.out.println(this.name + "正在睡觉");
    }

    public void sick() {
        System.out.println("生病");
    }

    void crazy() {
        System.out.println("抓狂了");
    }

    //打针
    public static void injection() {
        System.out.println("所有的动物月底打针");
    }

    public static String getTEXT_COMMUNITY_NAME() {
        return TEXT_COMMUNITY_NAME;
    }
    //抽象方法——————不能有实际意义
    //抽象方法必须有抽象类
    //抽象类可以没有抽象方法
    //你会发现，想象一下，动物叫声太多了，没有办法具体到某一个指定的叫声
    //?????
    public abstract void barking();
}