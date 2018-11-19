/**
 * File: ErrorLogger.java 　　2018/11/18 22:42
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Responsibility;

public class ErrorLogger extends AbstractLogger {
    @Override
    protected void write(String message) {
        System.out.println("Error:" + message);
    }
}
