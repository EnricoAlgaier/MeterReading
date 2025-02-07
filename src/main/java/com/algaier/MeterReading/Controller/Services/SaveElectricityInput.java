package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Layout.Components.CTextField;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SaveElectricityInput {
    private final DBConnect dbConnection;
    private final CTextField electricityField;
    private final CTextField dateField;
    private List<String> electricityFields, dateFields;
    private boolean dbInputState = false;

    public SaveElectricityInput(DBConnect dbConnection, CTextField electricityField, CTextField dateField) {
        this.dbConnection = dbConnection;
        this.electricityField = electricityField;
        this.dateField = dateField;
    }

    public void saveElectricity(String userEmail) {
        try {
            double cubic = Double.parseDouble(electricityFields.get(0));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(dateFields.get(0), formatter);
            LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.now());

            dbConnection.saveElectricityTable(cubic, dateTime, userEmail);

            dbInputState = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setElectricityTextInput(int fieldCounter) {
        electricityField.textInput(fieldCounter);
        electricityFields = new ArrayList<>();
        electricityFields = electricityField.getText();
    }

    public void setElectricityDateTextInput(int fieldCounter) {
        dateField.textInput(fieldCounter);
        dateFields = new ArrayList<>();
        dateFields = dateField.getText();
    }

    public boolean getDbInputState() {
        return dbInputState;
    }
}