package com.example.demo.service;
import com.example.demo.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SensorService {

    private static final String API_URL = "http://172.18.0.1:8082/devices";

    private final RestTemplate restTemplate;


    public SensorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Device> getDevices() {
        ResponseEntity<List<Device>> responseEntity = restTemplate.exchange(
                API_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Device>>() {});

        return responseEntity.getBody();
    }
}