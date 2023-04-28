package com.example.demo.BusinessLayer;

import com.example.demo.PersistanceLayer.RepositoryDream;
import com.example.demo.dtos.DreamDto;
import com.example.demo.models.Dream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.itextpdf.text.Document;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EnergyLevelNotify implements Notification {
    DreamDto dream;
    public EnergyLevelNotify(DreamDto dream){
        this.dream=dream;
    }
    @Override
    public void notifyUser(DreamDto dream){
        try {
            FileWriter myWriter = new FileWriter("energyLevel.txt");
            myWriter.write("Nivelul de energie e "+Long.toString(dream.getEnergyLevel()));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
