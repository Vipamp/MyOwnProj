/**
 * File: AbstractBook.java 　　2018/11/20 18:56
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


public abstract class AbstractBook {

    abstract public String getName();

    abstract public int getPrice();

    abstract public int getPageNums();

    abstract boolean isNil();

    abstract String show();
}
