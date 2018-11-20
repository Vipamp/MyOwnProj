/**
 * File: DemoTest.java 　　2018/11/20 19:59
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

public class DemoTest {
    public static void main(String[] args) {
        AbstractBook book = BookFactory.createBook("java", 10, 93);
        AbstractBook book1 = BookFactory.createBook("no", -1, -2);
        System.out.println(book.show());
    }
}
