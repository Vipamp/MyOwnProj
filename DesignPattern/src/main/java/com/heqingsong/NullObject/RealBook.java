/**
 * File: RealBook.java 　　2018/11/20 18:58
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

public class RealBook extends AbstractBook {

    String name;
    int price;
    int pageNums;

    public RealBook(String name, int price, int pageNums) {
        this.name = name;
        this.price = price;
        this.pageNums = pageNums;
    }

    public RealBook() {
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getPageNums() {
        return pageNums;
    }

    public void setPageNums(int pageNums) {
        this.pageNums = pageNums;
    }

    @Override
    public String toString() {
        return "RealBook{" + "name='" + name + '\'' + ", price='" + price + '\'' + ", pageNums='" + pageNums + '\'' + '}';
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String show() {
        return toString();
    }
}
