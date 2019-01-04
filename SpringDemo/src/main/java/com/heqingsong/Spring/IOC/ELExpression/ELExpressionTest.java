/**
 * File: ELExpressionTest.java 　　2018/11/24 11:25
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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ELExpressionTest {
    public static void main(String[] args){
        ApplicationContext ctx= new ClassPathXmlApplicationContext("IOCXmlFold/SpringEL.xml");
        Person person = (Person)ctx.getBean("person");
        System.out.println(person.toString());
    }
}
