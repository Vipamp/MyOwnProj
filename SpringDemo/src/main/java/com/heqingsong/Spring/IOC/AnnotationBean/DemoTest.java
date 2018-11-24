/**
 * File: DemoTest.java 　　2018/11/24 17:42
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.IOC.AnnotationBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("IOCXmlFold/AnnotationBean.xml");
        MyComponent myComponent = (MyComponent) ctx.getBean("myComponent");
        System.out.println(myComponent);

        MyService myService = (MyService) ctx.getBean("service");
        System.out.println(myService);

        MyController myController = (MyController) ctx.getBean("myController");
        System.out.println(myController);
    }
}
