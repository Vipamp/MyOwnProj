/**
 * File: ComputerFactory.java 　　2018/11/16 0:05
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Factory.SimpleFactory;

public class ComputerFactory {

    public static Computer getInstance(String computeType) {
        if ("mac".equals(computeType)) {
            return new MacComputer();
        } else if ("windows".equals(computeType)) {
            return new WindowsComputer();
        } else {
            return null;
        }
    }
}