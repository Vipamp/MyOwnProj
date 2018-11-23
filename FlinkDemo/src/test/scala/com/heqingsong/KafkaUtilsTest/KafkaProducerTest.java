/**
 * File: KafkaProducerTest.java 　　2018/11/21 11:49
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.heqingsong.KafkaUtilsTest;

import com.heqingsong.KafkaUtils.KafkaProducer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.Properties;

public class KafkaProducerTest {
    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        String ZOOKEEPER_HOST = "master:2181,slave01:2181,slave02:2181";
        String KAFKA_BROKER = "master:9092,slave01:9092,slave02:9092";
        String TRANSACTION_GROUP = "transaction";
        kafkaProps.setProperty("zookeeper.connect", ZOOKEEPER_HOST);
        kafkaProps.setProperty("bootstrap.servers", KAFKA_BROKER);
        kafkaProps.setProperty("group.id", TRANSACTION_GROUP);

        FlinkKafkaProducer<String> kafkaProducer = KafkaProducer.getInstance("test", kafkaProps);
    }
}
