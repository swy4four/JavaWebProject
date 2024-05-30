package student;

import java.util.ArrayList;
import java.util.List;


public class StudentList extends Baseutil {
    private List<Student> students;

    public StudentList() {
        students = new ArrayList<Student>();
    }
    public boolean addStudent(Student student) {

        String sql = "insert into student (name,gender,age,phone,email) values (?,?,?,?,?) ";
        Object[] os = {student.getName(),student.getGender(),student.getAge(),student.getPhone(),student.getEmail()};
        int i = dml(sql, os);
        if(i == 1) {
            return true;
        }
        return false;
    }
    public boolean replaceStudent(int index, Student student) {

        String sql = "update student set name = ? , gender = ? , "
                + " age = ? , phone = ?, email = ?  where id = ? ";
        Object[] os = {student.getName(),student.getGender(),student.getAge(),student.getPhone(),student.getEmail(),student.getId()};
        int i = dml(sql, os);
        if(i == 1) {
            return true;
        }
        return false;
    }
    //删除学生
    public boolean deleteStudent(int id) {
        //System.out.println("编号" + index);
        String sql = "delete from  student where id = ? ";
        Object[] os = {id};
        int i = dml(sql, os);
        if(i == 1) {
            return true;
        }
        return false;
    }
    public List<Student> getAllStudents() {
        String sql = "select * from student";
        return  dql(sql, null, Student.class);

    }
    public Student getStudent(int id) {
        String sql = "select * from student where id = ?";
        Object[] os = {id};
        return  dql(sql, os, Student.class).get(0);

    }

}

