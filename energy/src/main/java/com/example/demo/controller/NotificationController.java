package com.example.demo.controller;
import com.example.demo.Notification;
import com.example.demo.Value;
import com.example.demo.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
@CrossOrigin("http://localhost:3003")
public class NotificationController {
    private final SimpMessagingTemplate messagingTemplate;
    public NotificationController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
    @MessageMapping("/sendNotification")

    public void sendNotification() {
        String serverMessage = "Consum maxim depasit " ;
        System.out.println("mere websocketu");
        messagingTemplate.convertAndSend("/topic/notifications", new Notification(serverMessage));
    }

}
