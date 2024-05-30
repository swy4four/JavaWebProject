package com.icss.day08;

import java.util.Scanner;

public class Pizza {
    private String name;
    private double price;
    private String size;

    public Pizza(String name, double price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public void show() {
        System.out.println("名称:" + name + "\t大小:" + size+ "\t价格:" + price );
    }


    //培根披萨

    public static class BaconPizza extends Pizza {
        public BaconPizza(double prise,String size) {
            super("培根披萨",prise,size);
        }
    }

    //海鲜披萨
    public static class SeaPizza extends Pizza {
        public SeaPizza(double prise,String size) {
            super("海鲜披萨",prise,size);
        }
    }

    public static class Main {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入 您要制作的披萨 1.培根披萨  2.海鲜披萨");
            int choise = scanner.nextInt();

            Pizza pizza = null;

            if (choise == 1) {
                System.out.println("请输入培根披萨 大小和价格：");
                String size = scanner.next();
                int prise = scanner.nextInt();
                pizza =new BaconPizza(prise,size);
            }else if(choise ==2){
                System.out.println("请输入海鲜披萨大小和价格");
                String size = scanner.next();
                int prise = scanner.nextInt();
                pizza =new SeaPizza(prise,size);
            }else {
                System.out.println("输入错误");
                return;
            }
            System.out.println("你的选择是");
            pizza.show();
        }
    }
}
