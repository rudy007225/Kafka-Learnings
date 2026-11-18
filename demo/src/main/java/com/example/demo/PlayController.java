package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayController {

    private final VideoProducer producer;

    public PlayController(VideoProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/play")
    public String playMovie(@RequestParam String user, @RequestParam String movie) {
        String eventMessage = "User [" + user + "] plays [" + movie + "]";
        producer.sendPlayEvent(eventMessage);
        return "Request accepted! Please check console";
    }
}