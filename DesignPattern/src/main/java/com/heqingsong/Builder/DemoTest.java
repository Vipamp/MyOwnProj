/**
 * File: DemoTest.java 　　2018/11/17 1:27
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Builder;


public class DemoTest {
    public static void main(String[] args) {
        MacComputerBuilder macComputerBuilder = new MacComputerBuilder();
        MacComputer macComputer = (MacComputer) Designer.command(macComputerBuilder);
        System.out.println(macComputer.toString());

        WinComputerBuilder winComputerBuilder = new WinComputerBuilder();
        WinComputer windowsComputer = (WinComputer) Designer.command(winComputerBuilder);
        System.out.println(windowsComputer.toString());
    }
}
