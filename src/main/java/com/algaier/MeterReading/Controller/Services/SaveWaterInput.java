package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Layout.Components.CTextField;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SaveWaterInput {
    private final DBConnect dbConnection;
    private final CTextField waterField;
    private final CTextField dateField;
    private List<String> waterFields, dateFields;
    private boolean dbInputState = false;

    public SaveWaterInput(DBConnect dbConnection, CTextField waterField, CTextField dateField) {
        this.dbConnection = dbConnection;
        this.waterField = waterField;
        this.dateField = dateField;
    }

    public void saveWater(String waterType, String userEmail, double totalMonthValue) {
        try {
            double cubic = Double.parseDouble(waterFields.get(0));
            String place = waterFields.get(1);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(dateFields.get(0), formatter);
            LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.now());

            dbConnection.saveWaterTable(cubic, place, dateTime, waterType, userEmail, totalMonthValue);

            dbInputState = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setWaterTextInput(int fieldCounter) {
        waterField.textInput(fieldCounter);
        waterFields = new ArrayList<>();
        waterFields = waterField.getText();
    }

    public void setWaterDateTextInput(int fieldCounter) {
        dateField.textInput(fieldCounter);
        dateFields = new ArrayList<>();
        dateFields = dateField.getText();
    }

    public boolean getDbInputState() {
        return dbInputState;
    }
}