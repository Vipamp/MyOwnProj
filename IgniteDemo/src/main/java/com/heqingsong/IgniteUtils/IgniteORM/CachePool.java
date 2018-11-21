/**
 * File: CachePool.java 　　2018/11/1 10:11
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * this class is used to initialize ignite cache pool, for getting ignite cache by pojo class,  you can call
 * function 'getOrPushIgniteCache' to get corresponding ignite cache instance, if this corresponding ignite cache
 * is not exist, this function will create a new ignite instance automaticly.
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.IgniteUtils.IgniteORM;

import com.heqingsong.IgniteUtils.IgnitionBuilder.IgniteUtils;
import org.apache.ignite.IgniteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CachePool {
    private static Map<String, IgniteCache> poolMap = null;
    private static CachePool cachePool = null;
    private static String GETCACHENAME_METHOD = "getCacheName";
    private static Logger logger = LoggerFactory.getLogger(CachePool.class);

    /**
     * this function is used to initialize cache pool and return this, for managing many IngiteCache object.
     * but this class not support distribute system, only support localmodel
     *
     * @return : com.heqingsong.IgniteUtils.IgniteORM.CachePool
     * @author：HeQingsong
     */
    public static CachePool initAndGetCachePool() {
        if (null == cachePool) {
            synchronized (CachePool.class) {
                if (null == cachePool) {
                    cachePool = new CachePool();
                    CacheBuilder.init(IgniteUtils.getIgniteInstance());
                }
            }
        }
        return cachePool;
    }

    /**
     * by calling this function,you can get a ignite cache instance by sending parameters Class object of cache type
     *
     * @param clazz :
     * @return : org.apache.ignite.IgniteCache<java.lang.String,com.heqingsong.IgniteUtils.IgniteORM.AbstractPojoModel>
     * @author：HeQingsong
     * @date：18:36 2018/11/9
     */
    public IgniteCache<String, AbstractPojoModel> getOrPushIgniteCache(Class clazz) {
        IgniteCache igniteCache = null;
        try {
            String cacheName = String.valueOf(
                    clazz.getDeclaredMethod(GETCACHENAME_METHOD).invoke(clazz.newInstance(), null));
            if (null == poolMap || null == poolMap.get(cacheName)) {
                igniteCache = CacheBuilder.getIgniteCache(cacheName, clazz);
                registryCacheToPool(cacheName, igniteCache);
            } else {
                igniteCache = poolMap.get(cacheName);
            }
        } catch (Exception e) {
            logger.error("get Cache Name of class {} ERROR!", clazz);
        }
        return igniteCache;
    }

    /**
     * clear cache pool and stop ignite conection
     *
     * @author：HeQingsong
     */
    public void close() {
        logger.info("clear cache pool success! ");
        poolMap.clear();
        CacheBuilder.close();
    }

    /**
     * this function is used to put IgniteCache to cache pool, but can not be used for distributed system.
     *
     * @param cacheName   :
     * @param igniteCache :
     * @return : void
     * @author：HeQingsong
     * @date：21:48 2018/11/7
     */
    private static void registryCacheToPool(String cacheName, IgniteCache igniteCache) {
        if (poolMap == null) {
            synchronized (com.heqingsong.IgniteUtils.IgniteORM.CachePool.class) {
                if (poolMap == null) {
                    poolMap = new HashMap<>(10);
                }
            }
        }
        poolMap.put(cacheName, igniteCache);
    }
}
