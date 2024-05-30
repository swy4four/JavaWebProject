package com.practice.pra01;
/**
 * 狗类
 */
//继承
public class Dogs extends Animal {
    //alt + insert

    //这是他自己拥有的特性 是他自己的 不是来自他爸爸的 它从他爸爸那革新了
    //子类自己认为，应该打破他父亲的传统，进行革新，革新内容就是
    //方法体
    //重写（和继承有关 面向对象基础上 好处 ：拥有自己的方法）  重载（参数类型不同）

    //构造方法（函数）
    public Dogs() {
    }

    //alt + insert
    public Dogs(String name, String variety, int age, String food) {
        super(name, variety, age, food);
    }

    public Dogs(String name, int age) {
        super(name, age);
    }

    //重写了父类的方法
    @Override
    public void barking() {
        //超级 （父类）
//        super.barking();
        System.out.println("汪汪汪");
    }

    //反例 修饰
    //是否是导盲犬
    //设置成final
    //final 方法 不能被子类重写 你想为所欲为操作我的遗产，不可能，你呢？可以用 但是不能为所欲为
    public boolean isGuideBlindness(){
        return false;
    }

}

