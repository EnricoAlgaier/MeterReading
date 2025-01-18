package com.algaier.MeterReading.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Electricity")
public class Electricity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "KWh")
    private double kwh;

    @Column(name = "PriceID", nullable = false)
    private int price;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    @Column(name = "UserEmail")
    private String userEmail;

    public Electricity(double kwh, int price, LocalDateTime createdAt, String userEmail) {
        this.kwh = kwh;
        this.price = price;
        this.createdAt = createdAt;
        this.userEmail = userEmail;
    }

    public int getId() {
        return id;
    }

    public double getKwh() {
        return kwh;
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

    public void setKwh(double kwh) {
        this.kwh = kwh;
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