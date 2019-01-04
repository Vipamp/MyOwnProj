/**
 * File: AbstractFactory.java 　　2018/11/16 10:21
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

abstract public class AbstractFactory {
    abstract Juice createJuice();

    abstract Pie createPie();
}
