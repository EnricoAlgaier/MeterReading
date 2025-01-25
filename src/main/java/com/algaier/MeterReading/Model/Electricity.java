package com.algaier.MeterReading.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private String priceId;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UserEmail")
    private String userEmail;

    @Column(name = "TotalMonthValue")
    private Double totalMonthValue;

    public Electricity(){

    }

    public Electricity(double kwh, String priceId, LocalDateTime createdAt, String userEmail, Double totalMonthValue) {
        this.kwh = kwh;
        this.priceId = priceId;
        this.createdAt = createdAt;
        this.userEmail = userEmail;
        this.totalMonthValue = totalMonthValue;
    }

    public int getId() {
        return id;
    }

    public double getKwh() {
        return kwh;
    }

    public String getPrice() {
        return priceId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Double getTotalMonthValue() {
        return totalMonthValue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public void setPrice(String priceId) {
        this.priceId = priceId;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setTotalMonthValue(Double totalMonthValue) {
        this.totalMonthValue = totalMonthValue;
    }

    public List<String> electricitylist() {
        List<String> stringList = new ArrayList<>();
        stringList.add(String.valueOf(id));
        stringList.add(String.valueOf(kwh));
        stringList.add(priceId);
        stringList.add(createdAt.toString());
        stringList.add(String.valueOf(totalMonthValue));
        return stringList;
    }
}