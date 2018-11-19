/**
 * File: Empolyee.java 　　2018/11/18 15:07
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Composite;

import java.util.LinkedList;
import java.util.List;

public class Employee {
    String name;
    String dept;
    int salary;
    List<Employee> subEmpolyee = new LinkedList<Employee>();

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Employee> getSubEmpolyee() {
        return subEmpolyee;
    }

    public void setSubEmpolyee(List<Employee> subEmpolyee) {
        this.subEmpolyee = subEmpolyee;
    }

    public void add(Employee empolyee) {
        subEmpolyee.add(empolyee);
    }

    public List<Employee> getSubordinates() {
        return subEmpolyee;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", dept='" + dept + '\'' + ", salary=" + salary + '}';
    }
}