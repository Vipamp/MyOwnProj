/**
 * File: StaticInnerClass.java 　　2018/11/15 19:45
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Singleton;

public class StaticInnerClass {

    private static class StaticInnerClassHolder {
        private static final StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

    public StaticInnerClass() {
    }

    public StaticInnerClass getInstance() {
        return StaticInnerClassHolder.staticInnerClass;
    }
}
