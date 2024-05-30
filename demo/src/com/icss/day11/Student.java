package com.icss.day11;

//选择排序
//创建学生类 属性 包含id name age
// 数组存放至少5名同学信息
public class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Main {
        public static void selectionSort(Student[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j].id < arr[minIndex].id) {
                        minIndex = j;
                    }
                }
                // 将找到的最小元素与第一个元素交换
                Student temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        public static void main(String[] args) {
            Student[] students = new Student[5];
            students[0] = new Student(3, "大壮", 20);
            students[1] = new Student(1, "小强", 22);
            students[2] = new Student(5, "李四", 21);
            students[3] = new Student(4, "王五", 19);
            students[4] = new Student(2, "孟杰", 23);

            System.out.println("排序前:");
            for (Student student : students) {
                System.out.println(student);
            }

            selectionSort(students);

            System.out.println("\n排序后:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}