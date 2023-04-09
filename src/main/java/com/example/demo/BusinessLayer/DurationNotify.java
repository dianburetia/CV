package com.example.demo.BusinessLayer;

import com.example.demo.dtos.DreamDto;
import com.example.demo.models.Dream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class DurationNotify implements Notification{
    DreamDto dream;
    public DurationNotify(DreamDto dream){
        this.dream=dream;
    }
    @Override
    public void notifyUser(DreamDto dream){
        try {
            FileWriter myWriter = new FileWriter("duration.txt");
            myWriter.write("Durata somnului e de "+Long.toString(dream.getDuration()));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
