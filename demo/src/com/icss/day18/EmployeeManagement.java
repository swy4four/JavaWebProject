package com.icss.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManagement {

    private List<Map<String, String>> employeeList;

    public EmployeeManagement() {
        employeeList = new ArrayList<>();
    }

    // 添加员工信息到集合中
    public void addEmployee(String id, String name, String password, String position) {
        info(id, name, password, position, employeeList);
    }

    static void info(String id, String name, String password, String position, List<Map<String, String>> employeeList) {
        Map<String, String> employee = new HashMap<>();
        employee.put("员工编号", id);
        employee.put("姓名", name);
        employee.put("密码", password);
        employee.put("职务", position);
        employeeList.add(employee);
    }

    // 打印所有员工信息
    public void printEmployees() {
        for (Map<String, String> employee : employeeList) {
            System.out.println(employee);
        }
    }

    // 按编号查询员工信息
    public Map<String, String> findEmployeeById(String id) {
        for (Map<String, String> employee : employeeList) {
            if (employee.get("员工编号").equals(id)) {
                return employee;
            }
        }
        return null; // 未找到指定编号的员工信息
    }

    // 更新员工姓名
    public void updateEmployeeName(String oldName, String newName) {
        for (Map<String, String> employee : employeeList) {
            if (employee.get("姓名").equals(oldName)) {
                employee.put("姓名", newName);
                break;
            }
        }
    }

    // 从集合中移除员工
    public void removeEmployee(String name) {
        for (int i = 0; i < employeeList.size(); i++) {
            Map<String, String> employee = employeeList.get(i);
            if (employee.get("姓名").equals(name)) {
                employeeList.remove(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();

        // 添加员工信息
        management.addEmployee("s100", "李大国", "111", "厂长");
        management.addEmployee("s200", "赵四", "222", "舞王");
        management.addEmployee("s300", "香秀", "333", "厂长夫人");
        management.addEmployee("s400", "谢广坤", "444", "董事的爹");

        // 打印所有员工信息
        System.out.println("所有员工信息：");
        management.printEmployees();

        // 按编号查询员工信息
        String employeeId = "s200";
        System.out.println("\n查询员工编号为 " + employeeId + " 的信息：");
        Map<String, String> foundEmployee = management.findEmployeeById(employeeId);
        if (foundEmployee != null) {
            System.out.println(foundEmployee);
        } else {
            System.out.println("未找到员工编号为 " + employeeId + " 的信息。");
        }

        // 更新赵四的信息，将姓名改为赵国强
        String oldName = "赵四";
        String newName = "赵国强";
        System.out.println("\n更新员工姓名：" + oldName + " -> " + newName);
        management.updateEmployeeName(oldName, newName);
        management.printEmployees();

        // 从集合中移除谢广坤
        String removeName = "谢广坤";
        System.out.println("\n从集合中移除员工：" + removeName);
        management.removeEmployee(removeName);
        management.printEmployees();
    }
}