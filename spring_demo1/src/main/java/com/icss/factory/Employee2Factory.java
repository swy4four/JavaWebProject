package com.icss.factory;

import com.icss.bean.Employee;
/**
 * 静态工厂
 */
public class Employee2Factory {
    public static Employee create2Employee() {

        return new Employee(30, "王五", 2000);
    }
}
