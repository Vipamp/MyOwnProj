/**
 * File: ComputerBuilder.java 　　2018/11/16 14:58
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

public interface ComputerBuilder {

    void setSystem();

    void setMouse();

    void setKeyBoard();

    Computer getCompute();

}
