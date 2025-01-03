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

    @ManyToOne
    @JoinColumn(name = "PriceID", nullable = false)
    private Price price;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    public Electricity(double kwh, Price price, LocalDateTime createdAt) {
        this.kwh = kwh;
        this.price = price;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public double getKwh() {
        return kwh;
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

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}