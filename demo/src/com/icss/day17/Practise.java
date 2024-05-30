package com.icss.day17;

/**
 * 用户名验证
 * 小写字母开头 其他位上可以是字母数字下划线位数 6--8位
 * 当验证通过返回true 否则返回false
 * 利用字符串中的方法以及正则表达式两种方法实现验证
 */
public class Practise {
    public static void main(String[] args) {
        String name="a7890345";
        System.out.println(userName(name));
    }
    public static boolean userName(String name) {
        //验证用户名是否为空
        if (name == null || name.isEmpty()) {
            System.out.println("空");
            return false;
        }

        //验证用户名长度是否在6到8之间
        int length = name.length();
        if (name.length() < 6 || name.length() > 8) {
            System.out.println("长度问题");
            return false;
        }

        //判断 是否是小写字母开头
        char firstChar = name.charAt(0);
        if (!Character.isLowerCase(firstChar)) {
            System.out.println("不是小写字母开头");
            return false;
        }

        // 验证其他字符是否为字母、数字或下划线
        for (int i = 1; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!(Character.isLetterOrDigit(ch) || ch == '_')) {
                System.out.println("其他字符");
                return false;
            }
        }
        System.out.println("正确");
        return true;
    }

}
