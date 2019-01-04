/**
 * File: TraditionalMediaPlayerImpl.java 　　2018/11/17 20:59
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Adapter;

public class TraditionalMediaPlayerImpl implements TraditionalMediaPlayer {
    @Override
    public void playMp3(String fileName) {
        System.out.println("play mp3: " + fileName);
    }
}
