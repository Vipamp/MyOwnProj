/**
 * File: DemoTest.java 　　2018/11/18 14:44
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Bridge;

public class DemoTest {
    public static void main(String[] args) {
        Color color = new Red();
        Shape shape = new Circle();
        shape.setColor(color);
        shape.draw();

        Shape shape1 = new Rectangle();
        shape1.setColor(color);
        shape1.draw();
    }
}
