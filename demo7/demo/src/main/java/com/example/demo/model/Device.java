package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String descriptions;
    @JsonProperty
    private String address;
    @JsonProperty
    private float maximumConsumption;
    @JsonProperty
    private long accountId;

    public long getAccountId() {
        return accountId;
    }

    public Device(){}
    public Device(Long id, String descriptions, String address, float maximumConsumption, long accountId) {
        this.id = id;
        this.descriptions = descriptions;
        this.address = address;
        this.maximumConsumption = maximumConsumption;
        this.accountId = accountId;
    }

    public Device(String descriptions, String address, float maximumConsumption) {
        this.descriptions = descriptions;
        this.address = address;
        this.maximumConsumption = maximumConsumption;
    }
}