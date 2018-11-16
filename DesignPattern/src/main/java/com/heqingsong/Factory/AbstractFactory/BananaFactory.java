/**
 * File: JuiceFactory.java 　　2018/11/16 11:00
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Factory.AbstractFactory;

public class BananaFactory extends AbstractFactory {
    @Override
    Juice createJuice() {
        return new BananaJuice();
    }

    @Override
    Pie createPie() {
        return new BananaPie();
    }
}
