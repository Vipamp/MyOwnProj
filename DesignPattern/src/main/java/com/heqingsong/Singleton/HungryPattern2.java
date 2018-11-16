/**
 * File: HungryPattern.java 　　2018/11/15 19:29
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * 饿汉模式的变种，在静态代码块中，创建单例对象
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Singleton;

public class HungryPattern2 {
    private static HungryPattern2 hungryPattern = null;

    static {
        hungryPattern = new HungryPattern2();
    }

    private HungryPattern2() {

    }

    private static HungryPattern2 getInstance() {
        return hungryPattern;
    }
}
