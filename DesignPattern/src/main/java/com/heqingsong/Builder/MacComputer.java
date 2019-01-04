/**
 * File: MacConputer.java 　　2018/11/16 14:48
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

import lombok.Builder;

public class MacComputer extends Computer {
    private String system;
    private String mouse;
    private String keyBoard;

    @Override
    public String getSystem() {
        return system;
    }

    @Override
    public void setSystem(String system) {
        this.system = system;
    }

    @Override
    public String getMouse() {
        return mouse;
    }

    @Override
    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    @Override
    public String getKeyBoard() {
        return keyBoard;
    }

    @Override
    public void setKeyBoard(String keyBoard) {
        this.keyBoard = keyBoard;
    }

    @Override
    public String toString() {
        return "MacComputer{" + "system='" + system + '\'' + ", mouse='" + mouse + '\'' + ", keyBoard='" + keyBoard + '\'' + '}';
    }
}
