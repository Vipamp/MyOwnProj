/**
 * File: Var.java 　　2018/11/22 1:41
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.IOC.Bean;

public class Car {
    String brand;
    String addr;
    double price;
    int maxSpeed;

    public Car() {
    }

    public Car(String brand, String addr, int maxSpeed) {
        this.brand = brand;
        this.addr = addr;
        this.maxSpeed = maxSpeed;
    }

    public Car(String brand, String addr, double price) {
        this.brand = brand;
        this.addr = addr;
        this.price = price;
    }

    public Car(String brand, String addr, double price, int maxSpeed) {
        this.brand = brand;
        this.addr = addr;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" + "brand='" + brand + '\'' + ", addr='" + addr + '\'' + ", price=" + price + ", maxSpeed=" + maxSpeed + '}';
    }
}
