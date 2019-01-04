/**
 * File: HungryPattern.java 　　2018/11/15 19:29
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * 饿汉模式
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Singleton;

public class HungryPattern1 {
    /**
     * 在加载类时，就创建单例对象
     */
    private static HungryPattern1 hungryPattern = new HungryPattern1();

    private HungryPattern1() {

    }

    private static HungryPattern1 getInstance() {
        return hungryPattern;
    }
}
