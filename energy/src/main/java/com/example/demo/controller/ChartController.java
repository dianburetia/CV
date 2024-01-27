package com.example.demo.controller;

import com.example.demo.Value;
import com.example.demo.repositories.SensorRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/data")
@CrossOrigin("http://localhost:3003")
public class ChartController {

    private final SensorRepository sensorRepository;

    public ChartController(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @GetMapping("/values")
    public List<Double> getValuesFromDatabase() {
        // Assuming DataService has a method to fetch data from the database
        List<Value> databaseValues = sensorRepository.findAll();
        List<Double> returnedValues=new ArrayList<>();
        for(Value value:databaseValues){
            returnedValues.add(value.getValue());
        }
        return returnedValues;
    }
}
