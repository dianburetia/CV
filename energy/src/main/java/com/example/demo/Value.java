package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "values")
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="timestamp")
    private Long timestamp;
    @Column(name="deviceId")
    private long deviceId;
    @Column(name="value")
    private double value;
    @JsonProperty("timestamp")
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    @JsonProperty("deviceId")
    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }
    @JsonProperty("value")
    public void setValue(int value) {
        this.value = value;
    }
    @JsonProperty("timestamp")
    public Long getTimestamp() {
        return timestamp;
    }
    @JsonProperty("deviceId")
    public long getDeviceId() {
        return deviceId;
    }
    @JsonProperty("value")
    public double getValue() {
        return value;
    }
public Value(){}
    public Value(Long timestamp, long deviceId, double value) {
        this.timestamp = timestamp;
        this.deviceId = deviceId;
        this.value = value;
    }
}
