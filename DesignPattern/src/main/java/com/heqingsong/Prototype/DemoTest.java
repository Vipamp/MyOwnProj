/**
 * File: DemoTest.java 　　2018/11/16 14:33
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Prototype;

public class DemoTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        System.out.println(prototype.hashCode());

        Prototype prototype_copy = (Prototype) prototype.clone();
        System.out.println(prototype_copy.hashCode());

        System.out.println("prototype == prototype_copy? " + (prototype == prototype_copy));
        System.out.println("class of prototype = class of prototype_copy? " + (prototype.getClass() == prototype_copy.getClass()));

    }
}
