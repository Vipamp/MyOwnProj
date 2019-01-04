/**
 * File: DemoTest.java 　　2018/11/18 13:01
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Facade;

public class DemoTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        computer.shutdown();
    }
}
