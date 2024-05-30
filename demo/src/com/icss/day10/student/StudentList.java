package com.icss.day10.student;

/**
 * 学生信息列表管理模块
 */
public class StudentList {
    private Student[] students; // 用来保存学生信息对象的数组
    private int total; // 记录已保存学生信息对象的数量

    // 构造器，用来初始化Students数组
    public StudentList(int totalStudent) {
        students = new Student[totalStudent];
        total = 0;
    }

    // 将参数Student添加至数组中最后一个学生信息对象记录之后
    public boolean addStudent(Student student) {
        if (total < students.length) {
            students[total++] = student;
            return true;
        }
        return false;
    }

    // 用参数Student替换数组中由index指定的对象
    public boolean replaceStudent(int index, Student student) {
        if (index >= 0 && index < total) {
            students[index] = student;
            return true;
        }
        return false;
    }

    // 从数组中删除参数index指定索引位置的学生信息对象记录
    public boolean deleteStudent(int index) {
        if (index >= 0 && index < total) {
            for (int i = index; i < total - 1; i++) {
                students[i] = students[i + 1];
            }
            students[--total] = null;
            return true;
        }
        return false;
    }

    // 返回数组中记录的所有学生信息对象
    public Student[] getAllStudents() {
        Student[] allStudents = new Student[total];
        System.arraycopy(students, 0, allStudents, 0, total);
        return allStudents;
    }

    // 返回参数index指定索引位置的学生信息对象记录
    public Student getStudent(int index) {
        if (index >= 0 && index < total) {
            return students[index];
        }
        return null;
    }

    public int getTotal() {
        return total;
    }

}
