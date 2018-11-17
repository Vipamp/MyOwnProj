/**
 * File: AviMediaPlayer.java 　　2018/11/17 21:14
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

public class AviMediaPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {

    }

    @Override
    public void playAvi(String fileName) {
        System.out.println("play avi: " + fileName);
    }
}
