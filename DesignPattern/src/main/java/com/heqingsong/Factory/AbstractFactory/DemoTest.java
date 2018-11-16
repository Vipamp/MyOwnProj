/**
 * File: DemoTest.java 　　2018/11/16 11:07
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Factory.AbstractFactory;

public class DemoTest {
    public static void main(String[] args) {
        BananaFactory bananaFactory = new BananaFactory();
        bananaFactory.createJuice().desc();
        bananaFactory.createPie().desc();

        AppleFactory appleFactory = new AppleFactory();
        appleFactory.createJuice().desc();
        appleFactory.createPie().desc();
    }
}
