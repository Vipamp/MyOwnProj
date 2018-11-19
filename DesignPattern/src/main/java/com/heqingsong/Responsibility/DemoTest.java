/**
 * File: DemoTest.java 　　2018/11/18 22:42
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

public class DemoTest {
    public static void main(String[] args) {
        AbstractLogger infoLogger = new InfoLogger();
        AbstractLogger debugLogger = new DebugLogger();
        AbstractLogger errorLogger = new ErrorLogger();

        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        infoLogger.logMessage(AbstractLogger.INFO, "show info1");
        infoLogger.logMessage(AbstractLogger.DEBUG, "show info2");

    }
}
