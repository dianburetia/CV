package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageProducer messageProducer;
    @Autowired
    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }
    @GetMapping("/send")
    public String sendMessage() throws InterruptedException {
        //long timestamp = System.currentTimeMillis();
        messageProducer.sendMessage();//vor trebuite trecuta atata timestamp, cat si deviceID
        return "Message sent successfu";
    }

}