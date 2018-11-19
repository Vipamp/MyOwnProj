/**
 * File: Computer.java 　　2018/11/18 12:58
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Facade;

public class Computer {
    CPU cpu;
    Memory memory;
    Disk disk;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.disk = new Disk();
    }

    public void start() {
        System.out.println("===========>>> computer is starting <<<===========");
        this.cpu.start();
        this.memory.start();
        this.disk.start();
        System.out.println("===========>>> computer start ok !<<<===========\n");
    }

    public void shutdown() {
        System.out.println("===========>>> computer is shutdowning <<<===========");
        this.cpu.shutdown();
        this.memory.shutdown();
        this.disk.shutdown();
        System.out.println("===========>>> computer shutdown ok <<<===========!\n");
    }
}
