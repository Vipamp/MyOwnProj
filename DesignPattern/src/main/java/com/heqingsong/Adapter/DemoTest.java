/**
 * File: DemoTest.java 　　2018/11/17 21:20
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

public class DemoTest {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "My heart will go on.mp3");
        audioPlayer.play("mp4", "lesson 1.mp4");
        audioPlayer.play("avi", "lesson 2.avi");
        audioPlayer.play("vlc", "lesson 3.vlc");
    }
}
