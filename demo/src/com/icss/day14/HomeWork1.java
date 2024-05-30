package com.icss.day14;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        CaptchaCode();
        minMAxCode();
    }

    /*
        数组：存放0-9，A-Z,a-z
        通过随机数产生一个6位字符串，形成验证码
        用户输入验证码与随机验证码比对，判断验证码是否正确（忽略大小写比较）*/
    public static void CaptchaCode() {
        //1 数组 包含 0-9（10），A-Z（26）,a-z（26）62
        char[] chars = new char[62];
        for (int i = 0; i < 10; i++) {//0-9
            chars[i] = (char) ('0' + i);
        }
        for (int i = 0; i < 26; i++) {//A-Z
            chars[i + 10] = (char) ('A' + i);
        }
        for (int i = 0; i < 26; i++) {//0-9
            chars[i + 36] = (char) ('a' + i);
        }
        //测试 打印数组内容
        /*
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
         */

        //2 通过随机数 随机生成一个 六位数的 字符串
        Random random = new Random();
        StringBuilder captcha = new StringBuilder(6);//可变的字符串序列 通过它来动态构建字符串。
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(chars.length);
            captcha.append(chars[index]);
        }

        String genedCaptcha = captcha.toString();
        System.out.println("生成的验证码： " + genedCaptcha);
        //3 用户输入验证码
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 验证码：");
        String userInput = scanner.nextLine();

        //4 验证码比对 (忽略大小写)
        if (userInput.equalsIgnoreCase(genedCaptcha)) {
            System.out.println("验证码正确！");
        } else {
            System.out.println("验证码错误！");
        }
        scanner.close();

    }

    /*
	数组存 1-30
	用户通过随机数，产生一个5个数的组合
	组合中不能出现重复数字，从小到大排序*/
    public static void minMAxCode() {
        // 数组存 1-30
        int[] nums = new int[30];

        for (int i = 0; i < 30; i++) {
            nums[i] = i + 1;
        }
/*
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
 */

        //用户通过随机数，产生一个5个数的组合
        Random random = new Random();
        int[] captcha = new int[5];

        for (int i = 0; i < captcha.length; i++) {
            int index = random.nextInt(nums.length);
            captcha[i] = nums[index];
            //移除已选择的数字，以避免重复
            nums[index] = nums[nums.length - 1];
            nums = java.util.Arrays.copyOf(nums, nums.length - 1);
        }

        // 打印生成的5个数字的组合
        System.out.println("排序前的数字: " + Arrays.toString(captcha));
        //排序
        Arrays.sort(captcha);
        //最后结果
        System.out.println("排序后的数字: " + Arrays.toString(captcha));

    }

}