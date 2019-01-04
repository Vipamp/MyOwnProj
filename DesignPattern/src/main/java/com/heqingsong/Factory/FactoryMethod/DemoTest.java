/**
 * File: DemoTest.java 　　2018/11/16 0:24
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Factory.FactoryMethod;

public class DemoTest {
    public static void main(String[] args) {
        Computer mac = MacConputerFactory.makeCompute();
        Computer windows = WindowsComputerFactory.makeCompute();
        mac.say();
        windows.say();
    }
}
