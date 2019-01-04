/**
 * File: DemoTEST.java 　　2018/11/18 15:35
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.ShareUnit;

public class DemoTest {
    public static void main(String[] args) {
        Circle circlrInstance = CirclePool.getCirclrInstance(1, 2, 3);
        System.out.println(circlrInstance.hashCode() + ": " + circlrInstance);

        Circle circlrInstance2 = CirclePool.getCirclrInstance(1, 2, 3);
        System.out.println(circlrInstance2.hashCode() + ": " + circlrInstance2);

        Circle circlrInstance3 = CirclePool.getCirclrInstance(1, 2, 4);
        System.out.println(circlrInstance3.hashCode() + ": " + circlrInstance3);
    }
}
