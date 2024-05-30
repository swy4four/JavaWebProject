package student;


import java.util.List;

public class StudentView {
    private StudentList students = new StudentList();

    public void enterMainMenu() {


        boolean loopFlag = true;


        do {
            System.out.println("-----------学生信息管理系统-----------\n");
            String str = "\t1 添加学生\n\t2 修改学生\n\t3 删除学生\n\t4 查询学生\n\t5退出系统\n\n\t 请选择(1-5):_";
            System.out.print(str);

            //menuSelection 用户选择
            char menuSelection = Utility.readMenuSelection();
            System.out.println(menuSelection);

            switch (menuSelection) {
                case '1':

                    addNewStudent();
                    break;
                case '2':

                    modifyStudent();
                    break;

                case '3':
                    deleteStudent() ;
                    break;
                case '4':

                    listAllStudents() ;
                    break;
                case '5':
                    System.out.print("是否退出(Y/N):");
                    char yn = Utility.readConfirmSelection();
                    if(yn == 'Y') {
                        loopFlag = false;
                    }
            }



        } while (loopFlag);



    }
    private void addNewStudent() {
        System.out.println("-----添加学生信息-----");
        System.out.print("姓名:");
        String name = Utility.readString(10);
        System.out.print("性别:");
        char gender = Utility.readChar();
        System.out.print("年龄:");
        int age = Utility.readInt();
        System.out.print("电话:");
        String phone = Utility.readString(10);
        System.out.print("邮箱:");
        String email = Utility.readString(10);
        Student s = new Student(name, gender+"", age, phone, email);
        boolean b = students.addStudent(s);
        if(b) {
            System.out.println("-----添加信息完成-----");
        }else {
            System.out.println("-----添加信息失败-----");
        }

    }

    private void modifyStudent() {
        System.out.println("-----修改学生信息-----");
        System.out.println("请输入要修改学生编号:");
        int id = Utility.readInt();
        if (id == -1) {
            return;
        }

        Student s = students.getStudent(id);
        System.out.println(s);

        System.out.print("姓名(" + s.getName() + "):");
        s.setName(Utility.readString(10, s.getName()));
        System.out.print("性别(" + s.getGender() + "):");
        s.setGender(Utility.readString(3,s.getGender()));
        System.out.print("年龄(" + s.getAge() + "):");
        s.setAge(Utility.readInt(s.getAge()));

        System.out.print("电话(" + s.getPhone() + "):");
        s.setPhone(Utility.readString(10, s.getPhone()));
        System.out.print("邮箱(" + s.getEmail() + "):");
        s.setEmail(Utility.readString(10, s.getEmail()));

        boolean b = students.replaceStudent(id - 1, s);
        if (b) {
            System.out.println("-----修改信息完成-----");
        } else {
            System.out.println("-----修改信息失败-----");
        }

    }
    private void deleteStudent() {
        System.out.println("-----删除学生信息-----");
        System.out.println("请输入要删除学生编号:");
        int id = Utility.readInt();
        boolean  b = students.deleteStudent(id);
        if(b) {
            System.out.println("-----删除信息完成-----");
        }else {
            System.out.println("-----删除信息失败-----");
        }


    }
    private void listAllStudents() {
        System.out.println("-----查询学生信息-----");
        String str = "编号\t姓名\t性别\t年龄\t电话\t邮箱";
        System.out.println(str);
        List<Student>  ss = students.getAllStudents();
        for (Student student : ss) {
            System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getGender()
                    + "\t" + student.getAge() + "\t" + student.getPhone() + "\t " + student.getEmail());
        }
        System.out.println("-----查询信息完成-----");
    }
    public static void main(String[] args) {
        new StudentView().enterMainMenu();
    }


}
