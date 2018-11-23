/**
 * File: KafkaProducer.java 　　2018/11/15 17:38
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.KafkaUtils;

import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.streaming.util.serialization.SerializationSchema;

import java.util.Properties;

public class KafkaProducer {
    private static final String BROKERLIST = "broker-list";

    public static FlinkKafkaProducer<String> getInstance(String topic, Properties properties) {
        return new FlinkKafkaProducer<String>(properties.getProperty(BROKERLIST), topic, new SerializationSchema<byte[]>() {
            public byte[] serialize(byte[] bytes) {
                return new byte[0];
            }
        });
    }
}
