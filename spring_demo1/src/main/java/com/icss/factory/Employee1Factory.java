package com.icss.factory;

import com.icss.bean.Employee;
/**
 * 实例工厂
 */
public class Employee1Factory {
    public Employee create1Employee() {
        return new Employee(20, "李四", 1000);
    }
}
