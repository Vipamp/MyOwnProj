/**
 * File: MacConputerFactory.java 　　2018/11/16 0:21
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Factory.FactoryMethod;

public class MacConputerFactory {

    public static Computer makeCompute() {
        return new MacComputer();
    }
}
