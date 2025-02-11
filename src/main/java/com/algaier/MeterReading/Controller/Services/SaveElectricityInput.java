package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Model.Electricity;

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

    public enum ListValues {
        VALUE_ZERO(0);

        private final int value;

        ListValues(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public SaveElectricityInput(DBConnect dbConnection, CTextField electricityField, CTextField dateField) {
        this.dbConnection = dbConnection;
        this.electricityField = electricityField;
        this.dateField = dateField;
    }


    public void saveElectricity(String userEmail, double totalMonthValue, double kwh) {
        try {

            double cubic = Double.parseDouble(electricityFields.get(0));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(dateFields.get(ListValues.VALUE_ZERO.getValue()), formatter);
            LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.now());

            dbConnection.saveElectricityTable(kwh, dateTime, userEmail, totalMonthValue);

            dbInputState = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void checkTotalMonth(String userEmail){
        double resultKwh;
        double kwh = Double.parseDouble(electricityFields.get(ListValues.VALUE_ZERO.getValue()));
        String inputDate = dateFields.get(ListValues.VALUE_ZERO.getValue());
        String currentKwhString = electricityFields.get(ListValues.VALUE_ZERO.getValue());
        double currentKwh = Double.parseDouble(currentKwhString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(inputDate + " 00:00", formatter); // Time 00:00 default value
        String formattedDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Electricity electricity = dbConnection.readElectricity(userEmail, LocalDateTime.parse(formattedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        if(electricity == null){
            // default value
            resultKwh = 0.0;
        } else{
            resultKwh = currentKwh - electricity.getKwh();
        }
        saveElectricity(userEmail, resultKwh, kwh);
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