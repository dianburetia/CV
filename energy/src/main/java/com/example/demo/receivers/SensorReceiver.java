package com.example.demo.receivers;
import com.example.demo.Device;
import com.example.demo.DeviceId;
import com.example.demo.Value;
import com.example.demo.controller.NotificationController;
import com.example.demo.repositories.DeviceRepository;
import com.example.demo.repositories.SensorRepository;
import com.example.demo.service.SensorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SensorReceiver {
    @Autowired
    private SensorRepository sensorRepository;
     int value=0;int sum=0;


    @Autowired
    private DeviceRepository deviceRepository;
@Autowired
private SensorService sensorService;
    private final ObjectMapper objectMapper;

    private final NotificationController notificationController;

    public SensorReceiver(ObjectMapper objectMapper, NotificationController notificationController) {
        this.objectMapper = objectMapper;
        this.notificationController = notificationController;
    }
    @RabbitListener(queues = "your_queue_name")
    public void receiveMessage(String receivedValue) {
        Long convertedValue = Long.parseLong(receivedValue);
        System.out.println("Received value from the queue: " + convertedValue);
//        Long aa=Long.parseLong(deviceID);
        DeviceId deviceId=new DeviceId(convertedValue);
        deviceRepository.save(deviceId);//salvez in noua tabela
    }
    @RabbitListener(queues = "myQueue")
    public void processDoubleValue(String input) {
        String[] parts = input.split(" ");
        long a = Long.parseLong(parts[0]);
        double b = Double.parseDouble(parts[1]);
        long c = Long.parseLong(parts[2]);
        value++;
        sum += b;

        if (value % 6 == 0) {
            Value value = new Value(a, c, sum);
            sensorRepository.save(value);//salvez datele
            System.out.println(a + " " + sum + " " + c);
            List<Device> devices = sensorService.getDevices();
            for (Device device : devices) {
                if (device.getId() == c) {
                    System.out.println("Adresa e:" + device.getAddress());
                    if (device.getMaximumConsumption() < sum) {
                        //e bai, pornim websocketu cu notificarea
                        notificationController.sendNotification();
                    }
                }
            }
            sum=0;
        }
    }

}