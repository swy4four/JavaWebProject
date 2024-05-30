package com.practice.pra02;

public class Application {
    public static void main(String[] args) {
        //多态 有继承关系 向上转型 向下转型
        //多个行为 功能多了
        //替父从军
        //父类 new 子类 向上转型
        HuaHu huaHu=new HuaMuLan();

       /* System.out.println(huaHu.name);
        System.out.println(huaHu.age);
        HuaHu.sayMe();
        HuaMuLan.sayMe();*/

        //有一天仗打完了 遇到心爱的人 就要做回自己 向下转型 开始变化
        HuaMuLan huaMuLan =(HuaMuLan) huaHu;
        System.out.println(huaMuLan.name);
        System.out.println(huaMuLan.age);
        huaMuLan.dressing();
        HuaMuLan.sayMe();
    }
}