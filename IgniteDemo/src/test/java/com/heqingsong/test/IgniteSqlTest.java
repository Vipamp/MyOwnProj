/**
 * File: IgniteSqlTest.java 　　2018/10/30 21:59
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.test;

import com.heqingsong.IgniteSQL.TestDemo;
import com.heqingsong.IgniteUtils.IgnitionBuilder.IGNITETYPE;
import org.junit.Test;

public class IgniteSqlTest {
    @Test
    public void test1() {
        TestDemo.test(IGNITETYPE.EMBEDDED);
    }

    @Test
    public void test2() {
        TestDemo.test(IGNITETYPE.REMOTE);
    }
}

