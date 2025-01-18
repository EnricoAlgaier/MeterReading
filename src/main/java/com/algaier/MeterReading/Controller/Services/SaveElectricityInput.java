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
    private final CTextField eletricityField;
    private final CTextField dateField;
    private List<String> eletricityFields, dateFields;
    private boolean dbInputState = false;

    public SaveElectricityInput(DBConnect dbConnection, CTextField eletricityField, CTextField dateField) {
        this.dbConnection = dbConnection;
        this.eletricityField = eletricityField;
        this.dateField = dateField;
    }

    public void saveElectricity(String userEmail) {

        try {
            double cubic = Double.parseDouble(eletricityFields.get(0));

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
        eletricityField.textInput(fieldCounter);
        eletricityFields = new ArrayList<>();
        eletricityFields = eletricityField.getText();
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