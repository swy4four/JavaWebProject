package com.icss.day18;
/**
 * 没有封装
 * 创建一个集合用于存放员工
 * 员工信息如下
 *
 * 员工编号  姓名      密码    职务
 * s100     李大国     111     厂长
 * s200     赵四       222    舞王
 * s300     香秀       333    厂长夫人
 * s400     谢广坤     444    董事的爹
 *  将员工添加到集合中
 *  按编号查询员工
 *  更新赵四的信息，将赵四的姓名改为赵国强
 *  从集合中移除谢广坤
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Practise1 {

    public static void main(String[] args) {
        // 创建一个集合用于存放员工信息
        List<Map<String, String>> employeeList = new ArrayList<>();

        // 添加员工信息到集合中
        addEmployee(employeeList, "s100", "李大国", "111", "厂长");
        addEmployee(employeeList, "s200", "赵四", "222", "舞王");
        addEmployee(employeeList, "s300", "香秀", "333", "厂长夫人");
        addEmployee(employeeList, "s400", "谢广坤", "444", "董事的爹");

        // 打印所有员工信息
        System.out.println("所有员工信息：");
        printEmployees(employeeList);

        // 按编号查询员工信息
        String employeeId = "s200";
        System.out.println("\n查询员工编号为 " + employeeId + " 的信息：");
        Map<String, String> foundEmployee = findEmployeeById(employeeList, employeeId);
        if (foundEmployee != null) {
            System.out.println(foundEmployee);
        } else {
            System.out.println("未找到员工编号为 " + employeeId + " 的信息。");
        }

        // 更新赵四的信息，将姓名改为赵国强
        String oldName = "赵四";
        String newName = "赵国强";
        System.out.println("\n更新员工姓名：" + oldName + " -> " + newName);
        updateEmployeeName(employeeList, oldName, newName);
        printEmployees(employeeList);

        // 从集合中移除谢广坤
        String removeName = "谢广坤";
        System.out.println("\n从集合中移除员工：" + removeName);
        removeEmployee(employeeList, removeName);
        printEmployees(employeeList);
    }

    // 添加员工信息到集合中
    public static void addEmployee(List<Map<String, String>> employeeList,
                                   String id, String name, String password, String position) {
        EmployeeManagement.info(id, name, password, position, employeeList);
    }

    // 打印所有员工信息
    public static void printEmployees(List<Map<String, String>> employeeList) {
        for (Map<String, String> employee : employeeList) {
            System.out.println(employee);
        }
    }

    // 按编号查询员工信息
    public static Map<String, String> findEmployeeById(List<Map<String, String>> employeeList, String id) {
        for (Map<String, String> employee : employeeList) {
            if (employee.get("员工编号").equals(id)) {
                return employee;
            }
        }
        return null; // 未找到指定编号的员工信息
    }

    // 更新员工姓名
    public static void updateEmployeeName(List<Map<String, String>> employeeList, String oldName, String newName) {
        for (Map<String, String> employee : employeeList) {
            if (employee.get("姓名").equals(oldName)) {
                employee.put("姓名", newName);
                break;
            }
        }
    }

    // 从集合中移除员工
    public static void removeEmployee(List<Map<String, String>> employeeList, String name) {
        for (int i = 0; i < employeeList.size(); i++) {
            Map<String, String> employee = employeeList.get(i);
            if (employee.get("姓名").equals(name)) {
                employeeList.remove(i);
                break;
            }
        }
    }
}
