/**
 * File: CircleShape.java 　　2018/11/17 23:05
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

public class CircleShape implements Shape {

    @Override
    public void draw() {
        System.out.println("draw circle!");
    }
}
