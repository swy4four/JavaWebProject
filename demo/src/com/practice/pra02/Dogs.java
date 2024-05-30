package com.practice.pra02;


// 继承
public class Dogs extends Animal{  // 父和子 之间的关系 子继承 父亲的一些特征


    public Dogs() {
    }

    public Dogs(String name, String variety, int age, String food) {
        super(name, variety, age, food);
    }

    //这是他自己拥有的特性 是他自己的 不是来自他爸爸的 它从他爸爸那革新了
    // 子类自己认为 应该打破他父亲的传统 进行革新 革新的内容是
    //方法体
    //重写  重写了父类的方法
    @Override
    public void barking() {
        System.out.println("汪汪汪~~~~~~~");
    }

    //反例 修饰 子类不能重写
    public boolean isGuideBlindness(){
        return false;
    }
}
