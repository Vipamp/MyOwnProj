/**
 * File: HunguryPattern1.java 　　2018/11/15 19:17
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * 简单的懒汉式，线程不安全
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Singleton;


public class LazyPattern1 {
    /**
     * 成员对象都是private的，不允许外部访问
     */
    private static LazyPattern1 hunguryPattern = null;

    /**
     * 构造方法是私有的，不允许其他类创建对象
     */
    private LazyPattern1() {
    }

    /**
     * 懒汉模式最简单的写法，线程不安全
     *
     * @return : LazyPattern
     * @author：HeQingsong
     */
    public static LazyPattern1 getInstance() {
        if (hunguryPattern == null) {
            hunguryPattern = new LazyPattern1();
        }
        return hunguryPattern;
    }
}