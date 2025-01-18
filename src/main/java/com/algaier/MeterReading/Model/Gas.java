package com.algaier.MeterReading.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Gas")
public class Gas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "M³")
    private double m3;

    @Column(name = "PriceId")
    private int priceId;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    @Column(name = "UserEmail")
    private String userEmail;

    public Gas() {
    }

    public Gas(double m3, int priceId, LocalDateTime createdAt, String userEmail) {
        this.m3 = m3;
        this.priceId = priceId;
        this.createdAt = createdAt;
        this.userEmail = userEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getM3() {
        return m3;
    }

    public void setM3(double m3) {
        this.m3 = m3;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setUserId(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}