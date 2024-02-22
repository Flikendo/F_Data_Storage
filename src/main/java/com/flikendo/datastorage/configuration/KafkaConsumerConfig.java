package com.flikendo.datastorage.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 02-21-2024
 * Author: Flikendo
 *
 * KafkaConsumerConfig class. This class represent configures Kafka consumer
 */
@Configuration
public class KafkaConsumerConfig {
    // Reading from application.conf
    @Value("${spring.kafka.bootstrapServers}")
    private String bootstrapServers;

    /**
     * Configures consumer
     * @return a Map <String, Object> which contains the whole configuration
     */
    public Map<String, Object> consumerConfig() {
        Map<String, Object> properties = new HashMap<>();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return properties;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> consumer() {

    }
}
