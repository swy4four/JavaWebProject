
import java.lang.String;
import service.AdminService;
import service.StudentService;
import service.TeacherService;


import java.util.Scanner;

/**
 *RunApplication
 * 程序入口
 * 管理员登录 song  123456
 * Mysql 5.7 + jar 5.1.47
 *
 */
public class RunApplication {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用选课系统");
        System.out.println("请输入登录名: ");
        String ID = sc.next();

        System.out.println("请输入密码：");
        String password = sc.next();
        System.out.println("请选择您的身份");
        System.out.println("1.管理员");
        System.out.println("2.学生");
        System.out.println("3.教师");
        int a = sc.nextInt();
        switch(a){
            case 1:
                new AdminService().manLogin(ID,password);
                break;
            case 2:
                new StudentService().studentLogin(ID,password);
                break;
            case 3:
                new TeacherService().teacherLogin(ID,password);
            default:
                System.out.println("输入数字不合法，程序退出");
                System.exit(0);
        }
    }

}