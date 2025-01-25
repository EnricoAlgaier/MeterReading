package com.algaier.MeterReading.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "PriceId")
    private String priceId;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UserEmail")
    private String userEmail;

    @Column(name = "TotalMonthValue")
    private double totalMonthValue;

    public WaterCold(double m3, String place, String priceId, LocalDateTime createdAt, String userEmail, double totalMonthValue) {
        this.m3 = m3;
        this.place = place;
        this.priceId = priceId;
        this.createdAt = createdAt;
        this.userEmail = userEmail;
        this.totalMonthValue = totalMonthValue;
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

    public String getPrice() {
        return priceId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public double getTotalMonthValue() {
        return totalMonthValue;
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

    public void setPrice(String priceId) {
        this.priceId = priceId;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setTotalMonthValue(double totalMonthValue) {
        this.totalMonthValue = totalMonthValue;
    }

    public List<String> waterColdList() {
        List<String> stringList = new ArrayList<>();
        stringList.add(String.valueOf(id));
        stringList.add(String.valueOf(m3));
        stringList.add(priceId);
        stringList.add(createdAt.toString());
        stringList.add(String.valueOf(totalMonthValue));
        return stringList;
    }
}