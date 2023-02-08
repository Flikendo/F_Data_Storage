package com.flikendo.F_Data_Storage.Connection;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializerConfig;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.logging.log4j.message.SimpleMessage;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

/**
 * Date: 02-07-2023
 * Author: Flikendo
 *
 * KafkaConsumer class. This class is used to receive protobuf through Kafka from main service
 * (Producer-Consumer)
 */
public class KafkaProtoConsumer {
    // Properties for Kafka's configuration
    Properties props;

    /**
     * Constructor
     */
    public KafkaProtoConsumer() {
        this.props = new Properties();

        fillInProps();
    }

    /**
     * Fills in all properties with setting of Kafka
     */
    private void fillInProps() {
        this.props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        this.props.put(ConsumerConfig.GROUP_ID_CONFIG, "protobuf-consumer-group");
        this.props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        this.props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        this.props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaProtobufDeserializer.class);
        this.props.put(KafkaProtobufDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
    }

    /**
     * Receive protobuf from Kafka service
     *
     */
    public void receiveProtobuf() {
        final Consumer<String, Message> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("testproto"));

        try {
            while (true) {
                ConsumerRecords<String, Message> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, Message> record : records) {
                    for (Descriptors.FieldDescriptor field : record.value().getAllFields().keySet()) {
                        System.out.println(field.getName() + ": " + record.value().getField(field));
                    }
                }
            }
        } finally {
            consumer.close();
        }
    }





}
