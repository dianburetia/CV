package org.example;

public class SensorData {
    long timestamp;
    int deviceId;
    double data;

    public SensorData(long timestamp, int deviceId, double data) {
        this.timestamp = timestamp;
        this.deviceId = deviceId;
        this.data = data;
    }
}
