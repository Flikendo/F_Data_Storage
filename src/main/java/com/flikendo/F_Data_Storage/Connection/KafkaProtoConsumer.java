package com.flikendo.F_Data_Storage.Connection;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializerConfig;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import static com.flikendo.F_Data_Storage.Constants.DataInfo.*;

/**
 * Date: 02-07-2023
 * Author: Flikendo
 *
 * KafkaConsumer class. This class is used to receive protobuf through Kafka from main service
 * (Producer-Consumer)
 */
public class KafkaProtoConsumer {
    // Properties for Kafka's configuration
    private static Properties props;

    /**
     * Fills in all properties with setting of Kafka
     */
    public static void fillInProps() {
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_IP + ":" + BOOTSTRAP_SERVERS_PORT);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, AUTO_OFFSET_RESET);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaProtobufDeserializer.class);
        props.put(KafkaProtobufDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_URL + ":" + SCHEMA_REGISTRY_PORT);
    }

    /**
     * Receive protobuf from Kafka service
     */
    public static void receiveProtobuf() {
        final Consumer<String, Message> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("protoTub"));

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
