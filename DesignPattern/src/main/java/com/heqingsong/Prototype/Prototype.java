/**
 * File: DeepClone.java 　　2018/11/16 14:27
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Prototype;

public class Prototype implements Cloneable {

    private String name = "deep clone";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype deepClone = (Prototype) super.clone();
        return deepClone;
    }
}
