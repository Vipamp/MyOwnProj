/**
 * File: Leader.java 　　2018/11/19 10:15
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.Responsibility;

public abstract class Leader {

    Leader nextLeader;
    HolidayRequest holidayRequest;
    public String LEADERJOB = "leader";

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    abstract void treasRequest(HolidayRequest holidayRequest);

}
