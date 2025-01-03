package com.algaier.MeterReading.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "WaterCold")
public class WaterCold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "M³")
    private double m3;

    @Column(name = "Place")
    private String place;

    @ManyToOne
    @JoinColumn(name = "PriceID", nullable = false)
    private Price price;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    public WaterCold(double m3, String place, Price price, LocalDateTime createdAt) {
        this.m3 = m3;
        this.place = place;
        this.price = price;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public double getM3() {
        return m3;
    }

    public String getPlace() {
        return place;
    }

    public Price getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setM3(double m3) {
        this.m3 = m3;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}