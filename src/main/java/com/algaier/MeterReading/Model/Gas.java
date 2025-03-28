package com.algaier.MeterReading.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private String priceId;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UserEmail")
    private String userEmail;

    @Column(name = "TotalMonthValue")
    private double totalMonthValue;

    public Gas() {
    }

    public Gas(double m3, String priceId, LocalDateTime createdAt, String userEmail, double totalMonthValue) {
        this.m3 = m3;
        this.priceId = priceId;
        this.createdAt = createdAt;
        this.userEmail = userEmail;
        this.totalMonthValue = totalMonthValue;
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

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public double getTotalMonthValue() {
        return totalMonthValue;
    }

    public void setUserId(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setTotalMonthValue(double totalMonthValue) {
        this.totalMonthValue = totalMonthValue;
    }

    public List<String> gasList() {
        List<String> stringList = new ArrayList<>();
        stringList.add(String.valueOf(id));
        stringList.add(String.valueOf(m3));
        stringList.add(priceId);
        stringList.add(createdAt.toString());
        stringList.add(String.valueOf(totalMonthValue));
        return stringList;
    }
}