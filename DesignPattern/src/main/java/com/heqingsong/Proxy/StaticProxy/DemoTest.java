/**
 * File: DemoTest.java 　　2018/11/17 23:29
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Proxy.StaticProxy;

public class DemoTest {
    public static void main(String[] args) {
        Image image = new ImageProxy("myphoto.png");
        image.display();
    }
}
