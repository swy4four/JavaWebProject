package com.practice.pra02;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//抽象 abstract
public abstract class Animal {
    //NanG 小区名 静态变量
    private static final String TEXT_COMMUNITY_NAME = "NanG";
    //名字
    private String name;
    // 种类
    private String variety;
    //年龄
    private int age;
    //食物
    private String food;

    public Animal() {

    }
    //构造方法
    public Animal(String name, String variety, int age, String food) {
        this.name = name;
        this.variety = variety;
        this.age = age;
        this.food = food;
    }

    // 我们 要给一个 用户 能设置 能获取 但不能瞎搞的  get set
    public void setAge(int age) {
        if (age < 0 || age > 100) {

            System.out.println("您输入的数据不合法 已经默认清零");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    // 一个动作 这些方法 在类当中 有很好听的名字 叫做———— 行为

    public void eat() {
        System.out.println(this.name + "正在吃饭..吃："+this.food);
        //this指 的是对象
    }

    public void sleep() {
        System.out.println(this.name + "在睡觉");
    }

    public void sick() {
        System.out.println("生病");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", variety='" + variety + '\'' +
                ", age=" + age +
                ", food='" + food + '\'' +
                '}';
    }

    public static void injection() {
        System.out.println(" 所有动物月底打针！");
    }
    public static String getPlotInstance(){
        return TEXT_COMMUNITY_NAME;
    }

    //抽象方法————不能有实际意义
    //你会发现 想象一下 动物叫声太多了，没有办法具体到某一个指定的叫声
    //写了抽象方法 类必须是抽象类
    public abstract void barking();
}
