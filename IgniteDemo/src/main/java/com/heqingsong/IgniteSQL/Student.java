/**
 * @ClassName：Student
 * @Author：HeQingsong
 * @Date：2018/9/23 15:24
 * @Since：JDK1.8
 * @Version：1.0
 * @Description：//TODO
 */
package com.heqingsong.IgniteSQL;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Student {

    @QuerySqlField
    private int classId;

    @QuerySqlField
    private String name;

    @QuerySqlField
    private int age;

    public Student(int classId, String name, int age) {
        this.classId = classId;
        this.name = name;
        this.age = age;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [classId=" + classId + ", name=" + name + ", age="
                + age + "]";
    }
}
