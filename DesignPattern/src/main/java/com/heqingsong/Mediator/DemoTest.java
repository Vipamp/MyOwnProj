/**
 * File: DemoTest.java 　　2018/11/20 21:19
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Mediator;

public class DemoTest {
    public static void main(String[] args) {
        User jack = new User("Jack");
        User tom = new User("Tom");
        jack.showMessage("hello Tom");
        tom.showMessage("hi Jack");
    }
}
