/**
 * File: RemoteIgniteInstance.java 　　2018/10/30 21:12
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * Create remote Ignition object by singleton pattern, you can config uri to connect ignite cluster at
 * file src/main/resources/IgniteConf.xml.
 * The thread is safe. no matter how thread call function getRemoteIgniteInstance, all get the same Ignite object
 * <p>
 * This main function 'getRemoteIgniteInstance' will be called at function {@link com.heqingsong.IgniteUtils.IgnitionBuilder.IgniteUtils#getIgniteInstance()}
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.IgniteUtils.IgnitionBuilder;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;

public class RemoteIgniteInstance {
    private static RemoteIgniteInstance remoteIgniteInstance = null;
    private static Logger logger = Logger.getLogger(RemoteIgniteInstance.class);
    private static Ignite ignite = null;
    private static final String HOSTNAME_TAG = "IgniteConf-uriConf-hostname";
    private static final String PORT_TAG = "IgniteConf-uriConf-port";

    private RemoteIgniteInstance() {
    }

    /**
     * get remote ignite instance by calling this function
     *
     * @return : org.apache.ignite.Ignite
     * @author：HeQingsong
     * @date：21:23 2018/10/30
     */
    public static Ignite getRemoteIgniteInstance(HashMap<String, String> confMap) {
        if (remoteIgniteInstance == null) {
            synchronized (RemoteIgniteInstance.class) {
                if (remoteIgniteInstance == null) {
                    remoteIgniteInstance = new RemoteIgniteInstance();
                    ignite = getRemoteIgnite(confMap);
                }
            }
        }
        return ignite;
    }

    /**
     * this function is used to create remote ignite connection by TCP
     *
     * @return : org.apache.ignite.Ignite
     * @author：HeQingsong
     * @date：21:24 2018/10/30
     */
    private static Ignite getRemoteIgnite(HashMap<String, String> confMap) {
        TcpDiscoverySpi spi = new TcpDiscoverySpi();
        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
        String hostname = confMap.get(HOSTNAME_TAG);
        String port = confMap.get(PORT_TAG);
        ipFinder.setAddresses(Arrays.asList(hostname, port));
        spi.setIpFinder(ipFinder);
        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setDiscoverySpi(spi);
        logger.info("initizalize remote ignition succeess!");
        return Ignition.start(cfg);
    }
}
