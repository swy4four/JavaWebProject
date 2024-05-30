package student;

import java.io.Serializable;

/**
 * 学生类
 *
 */
public class Student  implements Serializable{
    private int id;
    private String name ;// 学生信息姓名
    private String gender ;// 性别
    private int age ;// 年龄
    private String phone;// 电话号码
    private String email ;//电子邮箱

    public Student() {

    }

    public Student(String name, String gender, int age, String phone, String email) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Student(int id,String name, String gender, int age, String phone, String email) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", phone=" + phone
                + ", email=" + email + "]";
    }





}
