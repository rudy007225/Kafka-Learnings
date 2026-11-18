package com.example.demo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class VideoProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public VideoProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPlayEvent(String message) {
        // "netflix-play-topic" naam ke folder (Topic) mein message bhej rahe hain
        kafkaTemplate.send("netflix-play-topic", message);
        System.out.println("1. [PRODUCER] Message has been sent to Kafka: " + message);
    }
}
