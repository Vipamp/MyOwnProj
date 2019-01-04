/**
 * File: BeanTest.java 　　2018/11/22 1:03
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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class BeanTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("IOCXmlFold/SpringBeanTest.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloworld");
        System.out.println(helloWorld);

        Car car1 = (Car) context.getBean("car1");
        Car car2 = (Car) context.getBean("car2");
        System.out.println(car1.toString());
        System.out.println(car2.toString());

        People people = (People) context.getBean("people");
        System.out.println(people.toString());

        People people2 = (People) context.getBean("people2");
        System.out.println(people2.toString());

        People people3 = (People) context.getBean("people3");
        System.out.println(people3.toString());

        MyProperties myProperties = (MyProperties) context.getBean("myProperties");
        Properties properties = myProperties.getProperties();
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("driver"));
        System.out.println(properties.getProperty("passwd"));

//        People people4 = (People) context.getBean("people4");
//        System.out.println(people4);
//        People people5 = (People) context.getBean("people4");
//        System.out.println(people5);

        System.out.println((People) context.getBean("people6"));
        System.out.println((People) context.getBean("people7"));
    }
}
