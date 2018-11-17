/**
 * File: ShapeDecorator.java 　　2018/11/17 23:06
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

public class ShapeDecorator {

    Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    public void draw() {
        shape.draw();
    }
}
