/**
 * File: IgniteUtils.java 　　2018/10/30 21:36
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * by this class you can choose ignition object type, remote or embedded,
 * <li> remote, will call {@link com.heqingsong.IgniteUtils.IgnitionBuilder.RemoteIgniteInstance} to get remote ignite</li>
 * <li> embedded, will call {@link com.heqingsong.IgniteUtils.IgnitionBuilder.EmbeddedIgniteInstance} to get embedded ignite</li>
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.IgniteUtils.IgnitionBuilder;

import org.apache.ignite.Ignite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class IgniteUtils {
    private static final HashMap<String, String> confMap;
    private static Logger logger = LoggerFactory.getLogger(IgniteUtils.class);
    private static final String IGNITETIONTYPETAG = "IgniteConf-IgnitationType";
    private static final String EMBEDDED = "EMBEDDED";
    private static final String REMOTE = "REMOTE";
    private static final String IGNITIONTYPE;

    /**
     * init configure map and get ignition type
     *
     * @return : null
     * @author：HeQingsong
     * @date：17:48 2018/11/6
     */
    static {
        confMap = IgniteConfParse.getConfMap();
        IGNITIONTYPE = confMap.get(IGNITETIONTYPETAG);
    }

    /**
     * this function is used to get ignite instance. you can config ignite type in XML file ,the tag is 'IgnitationType',
     * you can choose EMBEDDED or REMOTE type, each type has it's own instance builder class named
     * {@link com.heqingsong.IgniteUtils.IgnitionBuilder.EmbeddedIgniteInstance} and
     * {@link com.heqingsong.IgniteUtils.IgnitionBuilder.RemoteIgniteInstance}, each class has it's own method to read config map
     * to create Ignite object.
     *
     * @return : org.apache.ignite.Ignite
     * @author：HeQingsong
     * @date：12:16 2018/11/7
     */
    public static Ignite getIgniteInstance() {
        Ignite ignite;
        if (null == IGNITIONTYPE || EMBEDDED.equals(IGNITIONTYPE.toUpperCase())) {
            ignite = EmbeddedIgniteInstance.getEmbeddedIgniteInstance(confMap);
        } else if (REMOTE.equals(IGNITIONTYPE.toUpperCase())) {
            ignite = RemoteIgniteInstance.getRemoteIgniteInstance(confMap);
        } else {
            ignite = null;
            logger.error("{} is invalid ignition type, please make sure file IngiteConf.xml is exists and " +
                    "'IgniteConf-IgnitationType' TAG is EMEBDDED or REMOTE", IGNITIONTYPE);
        }
        return ignite;
    }
}
