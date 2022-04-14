package com.test.exkafka.controller;

import com.test.exkafka.service.KafkaProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "/kafka-test")
public class KafkaPublisherController {

    private final KafkaProducerService kafkaProducer;

    public KafkaPublisherController(KafkaProducerService kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public String sendMessage(
            @RequestParam(value = "message") String message
    ){
        log.info("message: {}", message);
        this.kafkaProducer.sendMessage(message);
        return "ok";
    }
}
