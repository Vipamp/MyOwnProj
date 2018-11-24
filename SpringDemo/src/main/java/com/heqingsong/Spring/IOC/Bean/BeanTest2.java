/**
 * File: AutoWiredDemo.java 　　2018/11/23 0:39
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

public class BeanTest2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeanTest2.xml");
        People people = (People) ctx.getBean("people");
        System.out.println(people);

        System.out.println((People) ctx.getBean("people2"));
        System.out.println((People) ctx.getBean("people3"));

        // 测试bean的作用域
        System.out.println("people3 == people3 ? " + String.valueOf((People) ctx.getBean("people3") == (People) ctx.getBean("people3")));
        System.out.println("people4 == people4 ? " + String.valueOf((People) ctx.getBean("people4") == (People) ctx.getBean("people4")));

    }
}
