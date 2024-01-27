package org.example;

import com.opencsv.exceptions.CsvValidationException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.Timestamp;
import java.util.Scanner;

import static java.lang.Long.parseLong;

@Component
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Autowired
    public MessageProducer(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void sendMessage() throws InterruptedException{
        try{
            File myObj = new File("sensor.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Long timestamp = System.currentTimeMillis();
//                rabbitTemplate.convertAndSend(queue.getName(), timestamp);
//                rabbitTemplate.convertAndSend(queue.getName(), Double.parseDouble(data));
//                rabbitTemplate.convertAndSend(queue.getName(), 1);
                SensorData sensorData = new SensorData(timestamp, 1,Double.parseDouble(data));
                String a=new String(timestamp+" "+Double.parseDouble(data)+" "+1);
                rabbitTemplate.convertAndSend(queue.getName(),a);
                System.out.println("Message sent: " + timestamp);
                System.out.println("Message sent: " + Double.parseDouble(data));
                Thread.sleep(10000);
                //System.out.println("Message sent: " + Double.parseDouble(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            File myObj = new File("sensor.csv");
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                Thread.sleep(1000); System.out.println(data);
//
//                for (int i = 0; i < data.length(); i++) {
//                    message.append(header[i]).append(": ").append(nextLine[i]).append(", ");
//                }
//                rabbitTemplate.convertAndSend(queue.getName(), message.toString());
//
//
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }


       // rabbitTemplate.convertAndSend(queue.getName(), message);
        //System.out.println("Message sent: " + message);
    }
}
