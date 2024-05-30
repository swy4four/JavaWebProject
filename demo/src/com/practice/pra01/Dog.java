//package com.practice.pra01;
//
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
///**
// * Song
// * 2023.10.11类 属性 public private lombok插件——>方法的重写  封装
// * 2023.10.12 toString  构造方法
// */
//// 我们把成员变量做的安全，使用private 代替 public 成员变量的特性， 我们另外提供 getter and setter ，这种方式 叫做 OOP ————— 封装
////不但可以在类上面写 也可以在方法中变量写
//@Getter
//@Setter
//@ToString
//// 狗是抽象的
////  狗类 都具有这些
////  类 当中的变量和方法都总称为 属性 (共性 特性)
//
//public class Dogs {
//
//    //成员变量：他们组成和构成了类 所以我们这么命名
//    //他们是类的重要组成部分
//    //狗名字
//    //public 公共的 公有的
//    //private 私有的   -----> 安全 例子 支付宝中用户的余额
//
//
//    //   @Getter @Setter 也可以 @Getter @Setter private String name;
//    //小区名 NanG (南瓜) static静态变量
//    //public static String plot = "NanG";
//    private static String plot ="NanG";
//    //狗名字
//    private String name;
//
//    //狗种类
//    private String variety;
//
//    //狗年龄
//    private int age;
//
//    //狗的食物
//    private String food;
//
//
//    // 构造方法
//
//    // 默认创建的 隐藏的 只要创建类 就会存在
//    //无参数构造函数 （无参数构造器） 把无参的写上 重点
//    public Dogs() {
//    }
//
//    //有参数构造函数
//    public Dogs(String name, String variety, int age, String food) {
//        this.name = name;
//        this.variety = variety;
//        this.age = age;
//        this.food = food;
//    }
//
//    //快捷键 ALT + INSERT
//
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public String getVariety() {
////        return variety;
////    }
////
////    public void setVariety(String variety) {
////        this.variety = variety;
////    }
//
//    //特殊的 单独搞出来 单独 写  ————> 方法的重写
////    public int getAge() {
////        return age;
////    }
////
//    public void setAge(int age) {
//        if (age < 0 || age > 30) {
//            this.age = 0;
//            System.out.println("您输入的数据不合法，已经默认清零！");
//        } else {
//            this.age = age;
//        }
//    }
//
//    public String getFood() {
//        return food;
//    }
////
////    public void setFood(String food) {
////        this.food = food;
////    }
//
//
//    // 我们要给一个用户能设置，能获取的，但不能瞎搞的 getter setter
////    public void setAge(int age) {
////        if (age < 0 || age > 100) {
////            this.age = 0;
////        } else {
////            this.age = age;
////        }
////    }
////
////    public int getAge() {
////        return this.age;
////    }
//
//    // 一个动作 方法（函数） 在类当中 有一个名字叫做---行为
//    public void eat() {
//        System.out.println(this.name + "狗正在吃饭");
//    }
//
//    //this.name 指调用对象
//    public void sleep() {
//        System.out.println(this.name + "狗正在睡觉");
//    }
//
//    public void sick() {
//        System.out.println("狗生病");
//    }
//
//    void crazy() {
//        System.out.println("狗抓狂了");
//    }
//
//    //打针
//    public static void injection() {
//        System.out.println("所有的狗月底打针");
//    }
//    public static String getPlot(){
//        return plot;
//    }
////    @Override
////    //重写 toString
////    public String toString() {
////        return "Dogs{" +
////                "name='" + name + '\'' +
////                ", variety='" + variety + '\'' +
////                ", age=" + age +
////                ", food='" + food + '\'' +
////                '}';
////    }
//}
