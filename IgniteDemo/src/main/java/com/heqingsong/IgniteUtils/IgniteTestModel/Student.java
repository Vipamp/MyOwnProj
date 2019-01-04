/**
 * File: Student.java 　　2018/11/9 19:20
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.IgniteUtils.IgniteTestModel;

import com.heqingsong.IgniteUtils.IgniteORM.AbstractPojoModel;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.HashMap;
import java.util.Map;

public class Student extends AbstractPojoModel<Student> {
    private static final String CACHE_NAME = "STUDENT";
    @QuerySqlField
    public Integer stuId;
    @QuerySqlField
    public String name;
    @QuerySqlField
    public Integer age;
    public Classes classes;

    private class COLUMNS {
        private static final String STUID = "stuId";
        private static final String NAME = "name";
        private static final String AGE = "age";
        private static final String CLASSES = "classes";
    }

    public Student() {
    }

    @Override
    public String keyBuilder() {
        return String.valueOf(this.stuId);
    }

    @Override
    public String getCacheName() {
        return CACHE_NAME;
    }

    @Override
    public Student mapToObject(Map<String, Object> map) {
        Student student = new Student();
        student.setStuId(Integer.parseInt((String) map.get(COLUMNS.STUID)));
        student.setName((String) map.get(COLUMNS.NAME));
        student.setAge(Integer.parseInt((String) map.get(COLUMNS.AGE)));
        student.setClasses((Classes) map.get(COLUMNS.CLASSES));
        return student;
    }

    @Override
    public Map<String, Object> objectToMap(Student student) {
        Map<String, Object> map = new HashMap<>(10);
        map.put(COLUMNS.STUID, String.valueOf(student.getStuId()));
        map.put(COLUMNS.AGE, String.valueOf(student.getAge()));
        map.put(COLUMNS.NAME, String.valueOf(student.getName()));
        map.put(COLUMNS.CLASSES, String.valueOf(student.getClasses()));
        return map;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classes=" + classes +
                '}';
    }
}
