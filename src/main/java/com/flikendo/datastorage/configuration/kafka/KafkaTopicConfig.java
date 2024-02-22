package com.flikendo.datastorage.configuration.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 02-22-2024
 * Author: Flikendo
 * KafkaTopicConfig class. This class configures Kafka topic
 */
@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.consumer.bootstrap-server}")
    private String bootstrapServers;
    @Value("${spring.kafka.topic}")
    private String topic;
    @Value("${spring.kafka.number-partitions}")
    private int numPartitions;
    @Value("${spring.kafka.replication-factor}")
    private int replicationFactor;

    /**
     * Creates KafkaAdmin object with the configuration which is established
     * @return KafkaAdmin objet
     */
    @Bean
    public KafkaAdmin createKafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }

    /**
     * Creates new topic
     * @return the creation of a new topic
     */
    @Bean
    public NewTopic createTopic() {
        return new NewTopic(topic, numPartitions, (short) replicationFactor);
    }
}
