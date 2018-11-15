/**
 * File: EmbeddedIgniteInstance.java 　　2018/10/30 21:31
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * Create embedded ignition object by singleton pattern, the thead is safe
 * <p>
 * This main function getEmbeddedIgniteInstance will be called at function {@link com.heqingsong.IgniteUtils.IgnitionBuilder.IgniteUtils#getIgniteInstance()}
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.IgniteUtils.IgnitionBuilder;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class EmbeddedIgniteInstance {
    private static EmbeddedIgniteInstance embeddedIgniteInstance = null;
    private static Logger logger = LoggerFactory.getLogger(EmbeddedIgniteInstance.class);
    private static Ignite ignite = null;

    private EmbeddedIgniteInstance() {
    }

    /**
     * this function is used to get embedded ignite instance
     *
     * @return : org.apache.ignite.Ignite
     * @author：HeQingsong
     * @date：21:54 2018/10/30
     */
    public static Ignite getEmbeddedIgniteInstance(HashMap<String, String> confMap) {
        if (embeddedIgniteInstance == null) {
            synchronized (EmbeddedIgniteInstance.class) {
                if (embeddedIgniteInstance == null) {
                    embeddedIgniteInstance = new EmbeddedIgniteInstance();
                    logger.info("initizalize embedded ignition succeess!");
                    ignite = Ignition.start();
                }
            }
        }
        return ignite;
    }
}
