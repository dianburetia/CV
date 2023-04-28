package com.example.demo.BusinessLayer;

import com.example.demo.dtos.DreamDto;
import com.example.demo.models.Dream;

import java.io.FileWriter;
import java.io.IOException;

public class StressNotify implements Notification {
    DreamDto dream;
    public StressNotify(DreamDto dream){
        this.dream=dream;
    }
    @Override
    public void notifyUser(DreamDto dream){
        try {
            FileWriter myWriter = new FileWriter("stress.txt");
            myWriter.write("Stresul somnului e de "+Long.toString(dream.getStress()));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
