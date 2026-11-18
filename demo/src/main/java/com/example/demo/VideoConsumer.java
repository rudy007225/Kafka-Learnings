package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class VideoConsumer {

    // Ye method hamesha "netflix-play-topic" par nazar rakhta hai
    @KafkaListener(topics = "netflix-play-topic", groupId = "netflix-demo-group")
    public void receivePlayEvent(String message) {
        System.out.println("2. [CONSUMER] Got the message from Kafka -> " + message);
    }
}