package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "device")
public class Device {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="descriptions")
    private String descriptions;
    @Column(name="address")
    private String address;
    @Column(name="maximumConsumption")
    private float maximumConsumption;
    @Column(name="accountId")
    private long accountId;

    public Device(String descriptions, String address, float maximumConsumption, long accountId) {
        this.descriptions = descriptions;
        this.address = address;
        this.maximumConsumption = maximumConsumption;
        this.accountId = accountId;
    }
}