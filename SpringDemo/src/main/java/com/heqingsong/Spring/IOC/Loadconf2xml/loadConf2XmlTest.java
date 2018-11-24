/**
 * File: loadConf2Xml.java 　　2018/11/23 16:53
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.IOC.Loadconf2xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class loadConf2XmlTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("IOCXmlFold/LoadConf2Xml.xml");
        DriverConf dbinfo = (DriverConf) ctx.getBean("driverInfo");
        System.out.println(dbinfo);
    }
}
