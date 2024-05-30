package com.icss.day09;

import java.util.Scanner;

class Car {
    String name;
    int rent;
    int capacity;

    public Car(String name, int rent, int capacity) {
        this.name = name;
        this.rent = rent;//租金
        this.capacity = capacity;//容量
    }

    public String getName() {
        return name;
    }

    public int getRent() {
        return rent;
    }

    public int getCapacity() {
        return capacity;
    }

    public static class CarRentalSystem {
        private static Car[] carCatalog = {
                new Car("奥迪A4", 500, 4),
                new Car("马自达6", 400, 4),
                new Car("皮卡雪6", 450, 4),
                new Car("金龙", 800, 20),
                new Car("松花江", 400, 4),
                new Car("依维柯", 1000, 20)
        };

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("欢迎使用租车系统");
            System.out.println("您是否要租车: 1是 0否");
            int choice = scanner.nextInt();
            if (choice == 1) {
                showCarCatalog();
                System.out.println("请输入您要租汽车的数量：");
                int num = scanner.nextInt();
                int totalPrice = 0;
                for (int i = 0; i < num; i++) {
                    System.out.println("请输入第" + (i + 1) + "辆车的序号和天数：");
                    int carNumber = scanner.nextInt();
                    int days = scanner.nextInt();
                    if (carNumber >= 1 && carNumber <= carCatalog.length) {
                        Car car = carCatalog[carNumber - 1];
                        int rent = car.getRent() * days;
                        System.out.println(car.getName() + "   " + days + "天");
                        totalPrice += rent;
                    } else {
                        System.out.println("输入的序号无效，请重新输入");
                        i--;
                    }
                }
                System.out.println("总价格：" + totalPrice + "元");
            } else {
                System.out.println("谢谢使用租车系统");
            }
        }

        private static void showCarCatalog() {
            System.out.println("您可租车的类型及其价目表");
            for (int i = 0; i < carCatalog.length; i++) {
                Car car = carCatalog[i];
                System.out.println("序号：" + (i + 1) + "  汽车名称:" + car.getName() + " 租金" + car.getRent() + "/天 容量：最多载人"
                        + car.getCapacity() + "人");
            }
        }
    }
}
