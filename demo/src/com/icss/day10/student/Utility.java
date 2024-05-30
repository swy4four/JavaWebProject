package com.icss.day10.student;

import java.util.*;

public class Utility {
	
    private static Scanner scanner = new Scanner(System.in);
    
	public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && 
                c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }

    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    /**
     * 控制台输入信息处理函数(逻辑验证)
     * @param limit 指定允许用户输入字符串的长度
     * @param blankReturn 指定是否必须为必填项（true,回车结束输入(允许不输入)，false:必须填写）代表是否必须要求用户输入
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        //判断用户输入信息
        while (scanner.hasNextLine()) {      //判断是否还有下一个输入项(hasNextLine()函数如何判断呢？)
            line = scanner.nextLine();       //获取用户输入
            if (line.length() == 0) {        //判断获取到的字符串长度是否为0
                if (blankReturn) return line;//判断传入的布尔类型参数(功能：如果获取到的输入是一个空白字符就退出函数,代表用户输入结束)
                else continue;               //否则跳过当前循环,进入下一次循环（不进行输入数据的验证)
            }

            //对用户输入信息进行逻辑验证
            if (line.length() < 1 || line.length() > limit) {//如果输入字符串长度小于1或者(短路或)长度大于指定长度
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;//跳过当前循环()
            }
            break;       //在什么情况下跳出while循环
        }

        return line;     //返回通过逻辑验证的合法字符串
    }
}
