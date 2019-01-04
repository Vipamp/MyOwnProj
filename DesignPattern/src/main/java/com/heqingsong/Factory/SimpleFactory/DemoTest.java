/**
 * File: DemoTest.java 　　2018/11/16 0:07
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Factory.SimpleFactory;

public class DemoTest {
    public static void main(String[] args) {
        Computer mac = ComputerFactory.getInstance("mac");
        Computer windows = ComputerFactory.getInstance("windows");
        mac.say();
        windows.say();
    }
}
