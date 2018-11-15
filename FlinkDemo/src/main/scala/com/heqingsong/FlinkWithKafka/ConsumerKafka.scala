/**
  * Author：HeQingsong
  * Time：2018/9/11 18:21
  * Description：
  */
package com.heqingsong.FlinkWithKafka

import java.util.Properties

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.{CheckpointingMode, TimeCharacteristic}
import org.apache.flink.streaming.connectors.kafka.{FlinkKafkaConsumer, FlinkKafkaConsumer081}
import org.apache.flink.streaming.util.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala._

object ConsumerKafka {
    private val ZOOKEEPER_HOST = "master:2181,slave01:2181,slave02:2181"
    private val KAFKA_BROKER = "master:9092,slave01:9092,slave02:9092"
    private val TRANSACTION_GROUP = "transaction"

    def main(args: Array[String]) {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)
        env.enableCheckpointing(1000)
        env.getCheckpointConfig.setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE)

        // configure Kafka consumer
        val kafkaProps = new Properties()
        kafkaProps.setProperty("zookeeper.connect", ZOOKEEPER_HOST)
        kafkaProps.setProperty("bootstrap.servers", KAFKA_BROKER)
        kafkaProps.setProperty("group.id", TRANSACTION_GROUP)

        //topicd的名字是new，schema默认使用SimpleStringSchema()即可
        val transaction = env
          .addSource(
              new FlinkKafkaConsumer081[String]("test", new SimpleStringSchema(), kafkaProps)
          )
        transaction.print()
        env.execute()
    }
}

