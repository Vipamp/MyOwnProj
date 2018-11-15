/**
 * File: Demo01.java 　　2018/11/12 11:05
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * 注解实现对象初始化
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Annotation.Demo01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Demo01 {
    public static void main(String[] args) {
        People p = new People();
        System.out.println(p.toString());
    }
}

// 这个必须要加上@Retention(RetentionPolicy.RUNTIME)，否则在代码运行时获取成员变量的注解获取不到
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface PeopleName {
    String name() default "";
}

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface PeopleAge {
    int age() default 0;
}

class People {
    public People() {
        Class clazz = this.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(PeopleName.class)) {
                PeopleName annotation = field.getAnnotation(PeopleName.class);
                this.name = annotation.name();
            } else if (field.isAnnotationPresent(PeopleAge.class)) {
                PeopleAge annotation = field.getAnnotation(PeopleAge.class);
                this.age = annotation.age();
            }
        }
    }

    @PeopleName(name = "HQS")
    String name;

    @PeopleAge(age = 25)
    int age;

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
        return "People{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
