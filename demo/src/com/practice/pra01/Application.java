package com.practice.pra01;

public class Application {
    public static void main(String[] args) {
        //张大爷 你可以试试了 这个APP先注册
        //对象  实例  对象大于实例
        //实例 ：显示生活的一个东西 ，对抽象的东西进行表示出来的产物
        //实例 实实在在的例子 证明

        //1. 用户创建了一个新账户 注册
        //Dogs zhangDog = new Dogs();
        //2. 注册完成之后，然后再补充资料
//        Dogs zhangDogs = new Dogs();
//        zhangDogs.setName("Jerry");
//        zhangDogs.setVariety("拉布拉多");
//        zhangDogs.setAge(10);
        //    System.out.println(zhangDogs.getAge());


        //初始化 定义+使用
//        int[] arrDogs = {1,2,3,4};

        //先定义
//        int[] arr = new int [4];
        //后使用
//        arr[0]= 1;
        //初始化对象（实例）
//        Dogs zhangDog = new Dogs("jerry","拉布拉多",2,null);

        //toString
//        System.out.println("zhangDog = "+zhangDog);

//        System.out.println("Dogs.plot = " + Dogs.getTEXT_COMMUNITY_NAME());


//        Dogs.injection();
        /*代码设计 需要的代码 */
        //设置狗的信息
//        zhangDogs.name = "jerry";
//        zhangDogs.age = 2;
//        zhangDogs.variety = "拉布拉多";


        //测试
//        System.out.println("张大爷家的狗的名字是" + zhangDogs.name);
//        System.out.println("王阿姨家的狗的名字是" + wangDogs.name);
//        //张大爷的狗睡觉了
//        zhangDogs.sleep();
    /*
    空指针异常 章节需要的代码
   */
        //注销吧
        // zhangDogs = null;
        // NullPointerException 空指针异常
        //System.out.println("zhangDogs name"+zhangDogs.name);
        //干掉就好了 以后不允许使用 对象属性有问题
        //垃圾回收机制
//        System.gc();

        //设置成private 不能new
        //{Earth.getEarthInstance() }创建ctrl alt v
//        Earth earthInstance = Earth.getEarthInstance();
//        earthInstance.hello();
//        Dogs zhangDog = new Dogs("Jerry","拉布拉多",2,"狗粮");
        //zhangDog.setName("Jerry");
        //zhangDog.setAge(2);
        //zhangDog.setFood("狗粮");


//        Cats liCat = new Cats("Tom","波斯",3,"猫粮");
//        liCat.setName("Tom");
//        liCat.setAge(3);
//        liCat.setFood("猫粮");

//        Hamsters wangHamster = new Hamsters();
//        wangHamster.setName("Bussy");
//        wangHamster.setAge(4);
//        wangHamster.setFood("鼠粮");

//
//        zhangDog.eat();
//        liCat.eat();
//        wangHamster.eat();
//        zhangDog.barking();
//        liCat.barking();
//        wangHamster.barking();

//        Labrador labrador=new Labrador();
//        System.out.println(labrador.isGuideBlindness());
        //Animal 本质来说是没有人用的,他是一个抽象的，他抽取了这些猫狗的共性，作为使用
        // 抽象----具体
        // 动物----狗
        //抽象的目的是为了概括（解释）这些事物

        //Animal 定义为抽象类 就不能new
        //Animal animal=new Animal();
//        Hamsters hamsters=new Hamsters();
//        hamsters.barking();


        Westerner westerner=new Westerner();
        westerner.eat();
        westerner.run();
//匿名内部类
        new Human() {
            @Override
            public void eat() {
                System.out.println("中国人吃中国菜");
            }

            @Override
            public void run() {

            }
        }.eat();
    }
}
