/**
 * File: Yellow.java 　　2018/11/18 14:35
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

public class Yellow implements Color {
    @Override
    public void paint(String shape) {
        System.out.println("黃色的："+shape);
    }
}
