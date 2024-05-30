package com.icss.day13;

/**
 * Object 是所有类的父类
 * 基类 /子类
 * 超类 /父类
 * */
public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        //System.out.println(new Object().toString());
        //System.out.println(new Object().hashCode());

        //System.out.println(new Cat("喵喵")==new Cat("喵喵"));//比较的是内存地址  堆
        //System.out.println(new Cat("喵喵").equals(new Cat("喵喵"))) ;

        //System.out.println(new Cat("汪汪")==new Cat("汪汪"));//false
        //System.out.println(new Cat("汪汪").equals(new Cat("汪汪"))) ;

        Sheep s1 =new Sheep("Mj");
        Sheep s2=s1.clone();
        System.out.println(s2);

        // clone 克隆也叫拷贝 分为深克隆 和浅克隆
        //浅克隆：如果克隆的属性是基本数据类型或String类型，那么浅克隆会分配内存空间 完成属性的复制
        //如果克隆的属性不是基本数据类型或String类型，是其他引用类型 则这个属性不会复制 而是直接引用原来的属性值

        // 深克隆：如果克隆的属性是基本数据类型或String类型，那么浅克隆会分配内存空间 完成属性的复制
        //如果克隆的属性不是基本数据类型或String类型，是其他引用类型,也会赋值
    }
}
