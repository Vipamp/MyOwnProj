/**
 * File: HelloWorld.java 　　2018/11/22 1:05
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Spring.IOC.Bean;

public class HelloWorld {
    String name;

    /**
     * 必须要有无参构造器
     */
    public HelloWorld() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloWorld{" + "name='" + name + '\'' + '}';
    }
}
