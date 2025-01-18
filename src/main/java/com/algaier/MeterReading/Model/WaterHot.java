package com.algaier.MeterReading.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "WaterHot")
public class WaterHot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "M³")
    private double m3;

    @Column(name = "Place")
    private String place;

    @Column(name = "PriceID")
    private int price;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    @Column(name = "UserEmail")
    private String userEmail;

    public WaterHot(double m3, String place, int price, LocalDateTime createdAt, String userEmail) {
        this.m3 = m3;
        this.place = place;
        this.price = price;
        this.createdAt = createdAt;
        this.userEmail = userEmail;
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

    public int getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getUserEmail() {
        return userEmail;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}