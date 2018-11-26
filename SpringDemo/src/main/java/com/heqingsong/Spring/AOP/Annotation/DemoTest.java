/**
 * File: DemoTest.java 　　2018/11/25 13:49
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.AOP.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("AOPXmlFold/AnnotationXml.xml");
        CalcInterface calc = (CalcInterface) ctx.getBean("calculator");
        System.out.println("9 * 3 = " + calc.mul(9, 3) + "\n");
        System.out.println("9 + 3 = " + calc.add(9, 3) + "\n");
        System.out.println("9 / 3 = " + calc.div(9, 0) + "\n");
        System.out.println("9 - 3 = " + calc.sub(9, 3) + "\n");
    }
}
