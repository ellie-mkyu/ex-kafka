package com.test.exkafka.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaProducerService {
    private static final String TOPIC = "chat";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info("[from producer] send message: {}", message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
