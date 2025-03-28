package com.algaier.MeterReading.Model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Product")
    private String product;

    @Column(name = "BasicCost")
    private BigDecimal basicCost;

    @Column(name = "Abatement")
    private BigDecimal abatement;

    @Column(name = "UserEmail")
    private String userEmail;

    public Price(){

    }

    public Price(BigDecimal price, String product, BigDecimal basicCost, BigDecimal abatement, String userEmail) {
        this.price = price;
        this.product = product;
        this.basicCost = basicCost;
        this.abatement = abatement;
        this.userEmail = userEmail;
    }


    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getBasicCost() {
        return basicCost;
    }

    public BigDecimal getAbatement() {
        return abatement;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setBasicCost(BigDecimal basicCost) {
        this.basicCost = basicCost;
    }

    public void setAbatement(BigDecimal abatement) {
        this.abatement = abatement;
    }

    public void setUserId(String userEmail) {
        this.userEmail = userEmail;
    }
}