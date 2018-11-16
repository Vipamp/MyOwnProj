/**
 * File: Designer.java 　　2018/11/17 1:11
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

public class Designer {
    public static Computer command(ComputerBuilder computerBuilder) {
        computerBuilder.setSystem();
        computerBuilder.setMouse();
        computerBuilder.setKeyBoard();
        return computerBuilder.getCompute();
    }
}
