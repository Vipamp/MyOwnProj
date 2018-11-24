/**
 * File: Person.java 　　2018/11/24 11:13
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.IOC.ELExpression;

public class Person {
    String name;
    int age;
    Car car;
    String carBrand;
    String carDesc;
    String level;

    public Person() {
    }

    public Person(String name, int age, Car car, String carBrand, String carDesc, String level) {
        this.name = name;
        this.age = age;
        this.car = car;
        this.carBrand = carBrand;
        this.carDesc = carDesc;
        this.level = level;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarDesc() {
        return carDesc;
    }

    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc;
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", carBrand='" + carBrand + '\'' +
                ", carDesc='" + carDesc + '\'' +
                ", level=" + level +
                '}';
    }
}
