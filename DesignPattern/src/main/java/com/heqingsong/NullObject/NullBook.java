/**
 * File: NullBook.java 　　2018/11/20 19:07
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.NullObject;

public class NullBook extends AbstractBook {

    @Override
    public String getName() {
        return "name is null";
    }

    @Override
    public int getPrice() {
        return -0;
    }

    @Override
    public int getPageNums() {
        return -1;
    }

    @Override
    boolean isNil() {
        return false;
    }

    @Override
    String show() {
        return "RealBook{" + getName() + ", " + getPrice() + ", " + getPageNums() + '}';
    }
}
