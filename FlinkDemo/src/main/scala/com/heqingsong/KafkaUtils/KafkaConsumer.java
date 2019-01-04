/**
 * File: KafkaConsumer.java 　　2018/11/15 17:13
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

import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer081;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;

import java.util.Properties;

public class KafkaConsumer {
    public static FlinkKafkaConsumer081<String> getInstance(String topic, Properties properties) {
        return new FlinkKafkaConsumer081<String>(topic, new SimpleStringSchema(), properties);
    }
}
