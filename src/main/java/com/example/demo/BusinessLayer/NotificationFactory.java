package com.example.demo.BusinessLayer;

import com.example.demo.PersistanceLayer.RepositoryDream;
import com.example.demo.dtos.DreamDto;
import com.example.demo.models.Dream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class NotificationFactory {

    public void  createNotification(DreamDto dreamdto, String channel) {
        switch (channel) {
            case "EnergyLevelNotify": {
                EnergyLevelNotify energyLevelNotify = new EnergyLevelNotify(dreamdto);
                energyLevelNotify.notifyUser(dreamdto);
            }

            case "StressNotify": {
                StressNotify stressNotify = new StressNotify(dreamdto);
                stressNotify.notifyUser(dreamdto);
            }

            case "DurationNotify": {
                DurationNotify durationNotify = new DurationNotify(dreamdto);
                durationNotify.notifyUser(dreamdto);
            }

        }
    }
    }

