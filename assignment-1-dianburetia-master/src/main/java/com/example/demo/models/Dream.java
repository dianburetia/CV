package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "dream")
public class Dream {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="duration")
    private Long duration;//in minutes
    @Column(name="energyLevel")
    private Long energyLevel;
    @Column(name="stress")
    private Long stress;

    public Dream(Long id,Long duration, Long energyLevel, Long stress) {
        this.id=id;
        this.duration = duration;
        this.energyLevel = energyLevel;
        this.stress = stress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getDuration() {
        return duration;
    }

    public Long getEnergyLevel() {
        return energyLevel;
    }

    public Long getStress() {
        return stress;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public void setEnergyLevel(Long energyLevel) {
        this.energyLevel = energyLevel;
    }

    public void setStress(Long stress) {
        this.stress = stress;
    }
}
