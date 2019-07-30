package com.example.demo.Service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendMessageTo(String fromUser, String toUser, String message){
        simpMessagingTemplate.convertAndSend("/getMessage/single/" + toUser + fromUser, message);
    }
}
