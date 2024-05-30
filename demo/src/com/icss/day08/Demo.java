package com.icss.day08;

/**
 * 演示多态
 */
public class Demo {
    public static void main(String[] args) {
        Person p = new Student();//多态 将子类对象赋值给父类引用 ：向上转型

        Student s=(Student)p;// 本态 还原  ：向下转型
        p.speak();//虚方法 （多态中子类重写方法）
        //多态 进行编译 时 编译的 是 父类型（方法） 执行的是子类型（方法）
        System.out.println(s.name);
        //没有虚属性 有什么类型的变量 属性 就是该类型中定义的属性
    }
}
