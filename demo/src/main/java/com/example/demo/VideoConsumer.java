package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class VideoConsumer {

// Service 1: Continue Watching (Differ Group)
    @KafkaListener(topics = "netflix-play-v2", groupId = "continue-watching-group")
    public void continueWatchingService(String message) {
        System.out.println("[CONTINUE WATCHING] Bookmark save kiya -> " + message);
    }
    
//Service 2 : Recommendation service(Differ group)
    @KafkaListener(topics = "netflix-play-v2", groupId = "recommentation-group")
    public void recommentationService(String message) {
    	System.out.println("[RECOMMENDATION] Suggested similer movies -> " + message);
    }
    
//Service 3 : Analytical Service (Differ group)
    @KafkaListener(topics = "netflix-play-v2", groupId = "analytics-group")
    public void analyticsWorker1(String message) {
    	System.out.println("[ANALYTICS-WORKER1] View count++ -> "+ message );
    }
    
//Service 4 : Analytical Service (Same group)
    @KafkaListener(topics = "netflix-play-v2", groupId = "analytics-group")
    public void analyticsWorker2(String message) {
    	System.out.println("[ANALYTICS-WORKER2] View count++ -> "+ message );
    }
}
