/**
 * File: DemoTest.java 　　2018/11/17 23:08
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Decorator;

public class DemoTest {
    public static void main(String[] args) {
        CircleShape circleShape = new CircleShape();
        ShapeDecorator circleShapeDecoratot = new ShapeDecorator(circleShape);
        circleShape.draw();

        RactangleShape ractangleShape = new RactangleShape();
        ShapeDecorator ractangleShapeDocorator = new ShapeDecorator(ractangleShape);
        ractangleShape.draw();
    }
}
