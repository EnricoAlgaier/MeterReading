package com.algaier.MeterReading.View.Electricity;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Model.Electricity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Overview {
    private final DBConnect dbConnect;

    public Overview(DBConnect dbConnect, String userEmail){
        this.dbConnect = dbConnect;


    }

    public List<Electricity> getDbValue(String userEmail){
        int counter = 3;

        LocalDateTime localDateTime = LocalDateTime.now().withHour(0).withMinute(0);

        return dbConnect.readAllElectricityValues(userEmail, localDateTime, counter);
    }

}