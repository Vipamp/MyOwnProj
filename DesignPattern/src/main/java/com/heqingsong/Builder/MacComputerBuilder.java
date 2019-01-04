/**
 * File: MacComputerBuilder.java 　　2018/11/16 14:49
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

public class MacComputerBuilder implements ComputerBuilder {
    private MacComputer macComputer = new MacComputer();

    @Override
    public void setSystem() {
        macComputer.setSystem("mac os");
    }

    @Override
    public void setMouse() {
        macComputer.setMouse("mac mouse");
    }

    @Override
    public void setKeyBoard() {
        macComputer.setKeyBoard("mac keyboard");
    }

    @Override
    public Computer getCompute() {
        return macComputer;
    }
}
