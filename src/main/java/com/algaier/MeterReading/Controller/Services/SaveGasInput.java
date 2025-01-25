package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Layout.Components.CTextField;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SaveGasInput {
    private final DBConnect dbConnection;
    private final CTextField gasField;
    private final CTextField dateField;
    private List<String> gasFields, dateFields;
    private boolean dbInputState = false;

    public SaveGasInput(DBConnect dbConnection, CTextField gasField, CTextField dateField) {
        this.dbConnection = dbConnection;
        this.gasField = gasField;
        this.dateField = dateField;
    }

    public void saveGas(String userEmail, double totalMonthValue) {

        try {
            double cubic = Double.parseDouble(gasFields.get(0));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(dateFields.get(0), formatter);
            LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.now());

            dbConnection.saveGasTable(cubic, dateTime, userEmail, totalMonthValue);

            dbInputState = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setGasTextInput(int fieldCounter) {
        gasField.textInput(fieldCounter);
        gasFields = new ArrayList<>();
        gasFields = gasField.getText();
    }

    public void setGasDateTextInput(int fieldCounter) {
        dateField.textInput(fieldCounter);
        dateFields = new ArrayList<>();
        dateFields = dateField.getText();
    }

    public boolean getDbInputState() {
        return dbInputState;
    }
}
