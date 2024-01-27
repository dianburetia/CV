package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "deviceids")
public class DeviceId {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="deviceId")
    private Long deviceId;

    public DeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}
