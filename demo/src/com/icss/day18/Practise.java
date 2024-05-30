package com.icss.day18;

import java.util.ArrayList;
import java.util.List;

/**
 * 没有封装
 * 创建一个集合用于存放员工
 * 员工信息如下
 * <p>
 * 员工编号  姓名      密码    职务
 * s100     李大国     111     厂长
 * s200     赵四       222    舞王
 * s300     香秀       333    厂长夫人
 * s400     谢广坤     444    董事的爹
 * 将员工添加到集合中
 * 按编号查询员工
 * 更新赵四的信息，将赵四的姓名改为赵国强
 * 从集合中移除谢广坤
 */
public class Practise {
    public static void main(String[] args) {
        //创建一个集合用于存放员工信息
        List<Emp> emps = new ArrayList<Emp>();
        Practise p= new Practise();
        // 添加员工信息到集合中
        p.addEmp(new Emp("s100", "李大国", "111", "厂长"),emps);
        p.addEmp(new Emp("s200", "赵四", "222", "舞王"),emps);
        p.addEmp(new Emp("s300", "香秀", "333", "厂长夫人"),emps);
        p.addEmp(new Emp("s400", "谢广坤 ", "444", " 董事的爹"),emps);
        System.out.println("员工信息");
        p.printEmps(emps);

        System.out.println("按编号查询员工");

    }
//添加
    public void addEmp(Emp e,List<Emp> emps){
        emps.add(e);
    }
// 打印
    public void printEmps(List<Emp> emps){
        for (Emp emp:emps
             ) {
            System.out.println(emp);
        }
    }
//
    public Emp queryEmp(String id, List<Emp> emps){
        Emp e=null;
        for (Emp emp:emps
             ) {
            if (emp.getId().equals(id)){
                e=emp;
                break;
            }
        }
        return e;
    }

    public void updateEmp(String oldName,String newName,List<Emp> emps){

        for (Emp emp : emps){
            if(emp.getName().equals(oldName)){
                emp.setName(newName);
                break;
            }

        }
    }

    public  void removeEmp (String name,List<Emp> emps){
        for (int i = 0; i < emps.size(); i++) {
            if (emps.get(i).getName().equals(name)){
                emps.remove(i);
                break;
            }

        }
    }
}
