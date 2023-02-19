package com.messenger.service.messengerservice.config;

import com.messenger.service.messengerservice.config.property.KafkaProperty;
import com.messenger.service.messengerservice.model.MessageEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConfiguration {
    private final KafkaProperty kafkaProperty;
    @Bean
    public ConsumerFactory<String, MessageEvent> consumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperty.getBootstrapServers());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperty.getGroupId());
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(
            config, new StringDeserializer(),
            new JsonDeserializer<>(MessageEvent.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MessageEvent> kafkaMessageContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MessageEvent> factory
            = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}
