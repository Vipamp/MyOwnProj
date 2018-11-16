/**
 * File: HunguryPattern2.java 　　2018/11/15 19:17
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * 带双重校验锁的懒汉式，线程安全
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Singleton;


public class LazyPattern2 {
    private volatile static LazyPattern2 hunguryPattern = null;

    /**
     * 构造方法是私有的，不允许其他类创建对象
     */
    private LazyPattern2() {
    }

    /**
     * 懒汉模式，加上线程同步和双重判断，保证在同一个时刻，只有一个线程有机会创建单例对象，下一个线程创建对象之前，先判断
     * 单例对象是否为空，从而保证线程安全
     *
     * @return : LazyPattern
     * @author：HeQingsong
     */
    public static LazyPattern2 getInstance2() {
        if (hunguryPattern == null) {
            synchronized (LazyPattern2.class) {
                if (hunguryPattern == null) {
                    hunguryPattern = new LazyPattern2();
                }
            }
        }
        return hunguryPattern;
    }
}
