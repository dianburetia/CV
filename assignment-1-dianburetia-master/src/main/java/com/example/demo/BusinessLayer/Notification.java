package com.example.demo.BusinessLayer;

import com.example.demo.dtos.DreamDto;
import com.example.demo.models.Dream;

public interface Notification {
    void notifyUser(DreamDto dream);

}
