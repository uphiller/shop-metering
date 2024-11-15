package com.shop.metering.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "id", groupId = "metering")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}