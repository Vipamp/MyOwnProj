/**
 * File: Rectangle.java 　　2018/11/18 14:43
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

public class Rectangle extends Shape {

    @Override
    public void draw() {
        color.paint("长方形");
    }
}
