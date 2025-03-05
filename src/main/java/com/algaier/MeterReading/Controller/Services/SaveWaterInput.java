package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Model.Gas;
import com.algaier.MeterReading.Model.WaterCold;
import com.algaier.MeterReading.Model.WaterHot;

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

    public SaveWaterInput(DBConnect dbConnection, CTextField waterField, CTextField dateField) {
        this.dbConnection = dbConnection;
        this.waterField = waterField;
        this.dateField = dateField;
    }

    public void saveWater(String waterType, String userEmail, double totalMonthValue, double cubic) {
        try {
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

    public void checkTotalMonth(String userEmail, String waterType){
        double resultCubic;
        double cubic = Double.parseDouble(waterFields.get(ListValues.VALUE_ZERO.getValue()));
        String inputDate = dateFields.get(ListValues.VALUE_ZERO.getValue());
        String currentCubicString = waterFields.get(ListValues.VALUE_ZERO.getValue());
        double currentCubic = Double.parseDouble(currentCubicString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(inputDate + " 00:00", formatter); // Time 00:00 default value
        String formattedDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        if (waterType.equals("hot")) {
            WaterHot waterHot = dbConnection.readWaterHot(userEmail, LocalDateTime.parse(formattedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            if(waterHot == null){
                // default value
                resultCubic = 0.0;
            } else{
                resultCubic = currentCubic - waterHot.getM3();
            }
            saveWater(waterType, userEmail, resultCubic, cubic);

        } else if(waterType.equals("cold")){
            WaterCold waterCold = dbConnection.readWaterCold(userEmail, LocalDateTime.parse(formattedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            if(waterCold == null){
                // default value
                resultCubic = 0.0;
            } else{
                resultCubic = currentCubic - waterCold.getM3();
            }
            saveWater(waterType, userEmail, resultCubic, cubic);
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