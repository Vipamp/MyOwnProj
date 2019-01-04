/**
 * File: IgniteType.java 　　2018/10/30 21:31
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */

package com.heqingsong.IgniteUtils.IgnitionBuilder;

public enum IGNITETYPE {
    /**
     * create {@link com.heqingsong.IgniteUtils.IgnitionBuilder.RemoteIgniteInstance} object
     */
    REMOTE,

    /**
     * create {@link com.heqingsong.IgniteUtils.IgnitionBuilder.EmbeddedIgniteInstance} object
     */
    EMBEDDED,
}
