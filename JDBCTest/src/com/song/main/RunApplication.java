package com.song.main;

import com.song.service.StudentService;

import java.util.Scanner;

/**
 * RunApplication
 * 运行入口
 */
public class RunApplication {
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {

        init();
    }

    /**
     * 主界面
     */
    public static void init(){

        System.out.println("-----------Welcome Students Management System---------");

        System.out.println("1.limit for 10 data\n2.update\n3.delete\n4.....\n5.quit");

        functionService();
    }

    /**
     * 功能模块
     */

    public static void functionService(){
        // 举例，此处可以自行修改
        switch (scanner.nextLine()) {
            // 1:
            case "1":
                System.out.println(StudentService.selectAll());
                break;

            // 2:
            case "2":
                StudentService.update(scanner.nextInt(), scanner.next(), scanner.nextInt());
                break;
            // 3:
            case "3":
                StudentService.delete(scanner.nextInt());
                break;
            // 4:...
            case "4":
                break;

            case "5":
                System.exit(0);
                break;
            default:
                break;
        }

    }
}
