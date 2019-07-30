package com.example.demo.controller;

import com.example.demo.Service.WebSocketService;
import com.example.demo.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {

    private WebSocketService webSocketService;

    public WebSocketController(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @MessageMapping(value = "/single/chat")
    public void sendMessage(Message message){
        webSocketService.sendMessageTo(message.getFromUser(), message.getToUser(), message.getMessage());
    }
}