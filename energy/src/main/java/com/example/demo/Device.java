package com.example.demo;

import jakarta.persistence.*;

public class Device {
        private Long id;
        private String descriptions;
        private String address;
        private float maximumConsumption;
        private long accountId;

    public Long getId() {
        return id;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getAddress() {
        return address;
    }

    public float getMaximumConsumption() {
        return maximumConsumption;
    }

    public long getAccountId() {
        return accountId;
    }

    public Device(long id,String descriptions, String address, float maximumConsumption, long accountId) {
        this.id=id;
            this.descriptions = descriptions;
            this.address = address;
            this.maximumConsumption = maximumConsumption;
            this.accountId = accountId;
        }
        public Device(){}
    }

