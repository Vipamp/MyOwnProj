/**
 * File: BookFactory.java 　　2018/11/20 19:08
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

public class BookFactory {
    public static AbstractBook createBook(String name, int price, int pageNums) {
        if ("".equals(name) && price > 0 && pageNums > 0) {
            return new RealBook(name, price, pageNums);
        } else {
            return new NullBook();
        }
    }
}
