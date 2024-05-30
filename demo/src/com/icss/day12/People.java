package com.icss.day12;

public class People extends Ape{
    public People(String s) {
        super(s);
    }

    @Override
    public void speak() {
        System.out.println("小样的，不错嘛！");
    }
    public void think(){
        System.out.println("别说话认真思考");
    }
}
