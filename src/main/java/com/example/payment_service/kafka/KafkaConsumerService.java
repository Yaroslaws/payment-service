package com.example.payment_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "pay-topic", groupId = "pay-group")
    public void consume(String message) {
        System.out.println("Received: " + message);
    }
}