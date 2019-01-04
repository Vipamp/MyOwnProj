/**
 * File: AudioPlayer.java 　　2018/11/17 21:17
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

public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equals(audioType)) {
            new TraditionalMediaPlayerImpl().playMp3(fileName);
        } else if ("mp4".equals(audioType) || "avi".equals(audioType)) {
            new MediaPlayerAdapter().play(audioType, fileName);
        } else {
            System.out.println("the file is wrong! please check!");
        }
    }
}
