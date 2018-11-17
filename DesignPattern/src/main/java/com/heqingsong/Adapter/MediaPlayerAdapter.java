/**
 * File: MediaPlayerAdapter.java 　　2018/11/17 21:04
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

public class MediaPlayerAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    @Override
    public void play(String audioType, String fileName) {
        if ("mp4".equals(audioType)) {
            advancedMediaPlayer = new MP4MediaPlayer();
            advancedMediaPlayer.playMp4(fileName);
        } else if ("avi".equals(audioType)) {
            advancedMediaPlayer = new AviMediaPlayer();
            advancedMediaPlayer.playAvi(fileName);
        }
    }
}
