/**
 * File: WinComputerBuilder.java 　　2018/11/16 15:18
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

public class WinComputerBuilder implements ComputerBuilder {
    private WinComputer winComputer = new WinComputer();

    @Override
    public void setSystem() {
        winComputer.setSystem("windows");
    }

    @Override
    public void setMouse() {
        winComputer.setMouse("windows mouse");
    }

    @Override
    public void setKeyBoard() {
        winComputer.setKeyBoard("windows keyboard");
    }

    @Override
    public Computer getCompute() {
        return winComputer;
    }
}
