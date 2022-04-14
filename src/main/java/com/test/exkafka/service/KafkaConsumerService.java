package com.test.exkafka.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "chat", groupId = "test")
    public void receive(String message) {
        log.info("[from product] received message: {}", message);
    }
}
