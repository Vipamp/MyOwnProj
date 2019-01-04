/**
 * File: Shape.java 　　2018/11/18 14:27
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

public abstract class Shape {
    Color color =null;


    public void setColor(Color color) {
        this.color = color;
    }

    abstract public void draw();
}
