package com.icss.day10.student;

/**
 * StudentView为主模块
 * 负责菜单的显示和处理用户操作
 */

public class StudentView {

    private StudentList students;

    public StudentView() {
        students = new StudentList(10); // 创建最大包含10个学生信息对象的StudentList对象
    }

    public void enterMainMenu() {
        char choice;

        do {
            System.out.println("------学生信息管理系统------");
            System.out.println("\t1. 添加学生信息");
            System.out.println("\t2. 修改学生信息");
            System.out.println("\t3. 删除学生信息");
            System.out.println("\t4. 学生信息列表");
            System.out.println("\t5. 退\t\t出");
            System.out.print("请输入您的选择：");

            choice = Utility.readMenuSelection();

            switch (choice) {
                case '1':
                    addNewStudent();
                    break;
                case '2':
                    modifyStudent();
                    break;
                case '3':
                    deleteStudent();
                    break;
                case '4':
                    listAllStudents();
                    break;
                case '5':
                    System.out.println("程序已退出。");
                    return;
                default:
                    System.out.println("无效的选择，请重新输入。");
            }
        } while (choice != 5);
    }

    private void addNewStudent() {
        // 添加学生信息
        System.out.println("------添加学生信息------");
        // 读取用户输入的学生信息并添加到学生列表中
        System.out.print("请输入学生姓名：");
        String name = Utility.readString(20); // 假设最大长度为20
        System.out.print("请输入学生性别（男/女）：");
        char gender = Utility.readChar();
        System.out.print("请输入学生年龄：");
        int age = Utility.readInt();
        System.out.print("请输入学生电话：");
        String phone = Utility.readString(11); // 假设电话号码长度为11
        System.out.print("请输入学生邮箱：");
        String email = Utility.readString(50); // 假设邮箱最大长度为50

        Student student = new Student(name, gender, age, phone, email);
        boolean success = students.addStudent(student);
        if (success) {
            System.out.println("学生信息添加成功！");
        } else {
            System.out.println("学生信息添加失败，学生列表已满！");
        }
    }

    private void modifyStudent() {
        // 修改学生信息
        System.out.println("------修改学生信息------");
        // 读取用户输入的学生编号并在列表中查找对应的学生信息
        System.out.print("请输入要修改的学生编号：");
        int index = Utility.readInt();
        if (index < 1 || index > students.getTotal()) {
            System.out.println("学生编号无效！");
            return;
        }
        Student student = students.getStudent(index - 1);
        if (student == null) {
            System.out.println("未找到该学生信息！");
        } else {
            // 修改学生信息
            System.out.println("当前学生信息：" + student);
            System.out.println("请输入新的学生信息：");
            System.out.print("姓名：");
            student.setName(Utility.readString(20)); // 假设姓名最大长度为20
            System.out.print("性别（男/女）：");
            student.setGender(Utility.readChar());
            System.out.print("年龄：");
            student.setAge(Utility.readInt());
            System.out.print("电话：");
            student.setPhone(Utility.readString(11)); // 假设电话号码长度为11
            System.out.print("邮箱：");
            student.setEmail(Utility.readString(50)); // 假设邮箱最大长度为50

            System.out.println("学生信息修改成功！");
        }
    }

    private void deleteStudent() {
        // 删除学生信息
        System.out.println("------删除学生信息------");
        // 读取用户输入的学生编号并在列表中查找对应的学生信息
        System.out.print("请输入要删除的学生编号：");
        int index = Utility.readInt();
        if (index < 1 || index > students.getTotal()) {
            System.out.println("学生编号无效！");
            return;
        }
        boolean success = students.deleteStudent(index - 1);
        if (success) {
            System.out.println("学生信息删除成功！");
        } else {
            System.out.println("未找到该学生信息，删除失败！");
        }
    }

    private void listAllStudents() {
        // 显示学生信息
        System.out.println("------学生信息列表------");
        // 获取所有学生信息
        Student[] allStudents = students.getAllStudents();
        if (allStudents.length == 0) {
            System.out.println("暂无学生信息！");
        } else {
            // 遍历并打印所有学生信息
            for (Student student : allStudents) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        StudentView studentView = new StudentView();
        studentView.enterMainMenu();
    }

}
