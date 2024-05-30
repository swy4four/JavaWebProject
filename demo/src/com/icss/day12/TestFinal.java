package com.icss.day12;

public class TestFinal {
    final int num =10; // final 修饰的属性只能赋值一次

    public static void main(String[] args) {
        // new TestFinal().num=20;
        final int i=1;//fianl 修饰的局部变量 只能赋值一次
        // fianl 修饰的变量（无论局部变量还是成员变量）都只赋值一次 这类变量叫做常量

    }
    public void a(final String name){//形参等价于局部变量
        //name ="hello";

    }

    public final void b(){
        System.out.println("bbbbbb");
    }
}

//fianl 修饰的类不能有子类

class TestFinalChild extends TestFinal{
    //final 修饰的方法不能重写

}
