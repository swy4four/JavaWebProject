package com.icss.day12;
/*
* 主方法没写 重点错误
* */
public class E {
    public static void main(String[] args) {
        Ape ape = new Ape("类人猿");
        People people = new People("人");

        ape.speak();
        people.speak();
        people.think();
    }
}
