package com.food;

import java.util.Scanner;

public class ScannerChoice {
    private static Scanner scanner;

    /**
     * 获取键盘输入字符串
     *
     * @return 输入的字符串
     * 通过 Scanner 类从标准输入（键盘）读取用户输入的字符串。
     * 提示用户输入，并返回用户输入的字符串。
     */
    public static String scannerInfoString() {
        scanner = new Scanner(System.in);
        System.out.print("请输入: ");
        String input = scanner.next();
        scanner.nextLine();  // 清除输入缓冲区中的换行符
        return input;
    }

    /**
     * 获取键盘输入整数
     *
     * @return 输入的整数
     * 通过 Scanner 类从标准输入读取用户输入的整数。
     * 循环检查输入是否为整数，如果不是，提示用户重新输入，直到获取一个整数。
     * 返回用户输入的整数
     */
    public static int scannerInfoInt() {
        scanner = new Scanner(System.in);
        System.out.print("请输入整数: ");
        while (!scanner.hasNextInt()) {
            System.out.print("输入有误，请输入整数: ");
            scanner.next();  // 清除非整数输入
        }
        int input = scanner.nextInt();
        scanner.nextLine();  // 清除输入缓冲区中的换行符
        return input;
    }

    /**
     * 获取键盘输入浮点数
     *
     * @return 输入的浮点数
     * 通过 Scanner 类从标准输入读取用户输入的浮点数。
     * 循环检查输入是否为浮点数，如果不是，提示用户重新输入，直到获取一个浮点数。
     * 返回用户输入的浮点数。
     */
    public static double scannerInfoDouble() {
        scanner = new Scanner(System.in);
        System.out.print("请输入数字: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("输入有误，请输入数字: ");
            scanner.next();  // 清除非数字输入
        }
        double input = scanner.nextDouble();
        scanner.nextLine();  // 清除输入缓冲区中的换行符
        return input;
    }
}
