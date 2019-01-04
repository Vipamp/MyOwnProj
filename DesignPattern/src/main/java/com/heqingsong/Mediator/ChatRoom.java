/**
 * File: ChatRoom.java 　　2018/11/20 21:15
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Mediator;

import java.util.Date;

public class ChatRoom {

    public static void showMessage(User user, String msg) {
        System.out.println(new Date().toString() + " [ " + user.getName() + " ]: " + msg);
    }
}
