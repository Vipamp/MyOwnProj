/**
 * File: DemoTest.java 　　2018/11/20 21:04
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Command;

public class DemoTest {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new DeleteCommand());
        invoker.execute();

        invoker.setCommand(new UpdateCommand());
        invoker.execute();

        invoker.setCommand(new InsertCommnd());
        invoker.execute();
    }
}
