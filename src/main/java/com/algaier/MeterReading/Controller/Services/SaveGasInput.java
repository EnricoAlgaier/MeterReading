package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Model.Electricity;
import com.algaier.MeterReading.Model.Gas;

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

    public SaveGasInput(DBConnect dbConnection, CTextField gasField, CTextField dateField) {
        this.dbConnection = dbConnection;
        this.gasField = gasField;
        this.dateField = dateField;
    }

    public void saveGas(String userEmail, Double totalMonthValue,  double cubic) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(dateFields.get(0), formatter);
            LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.now());

            dbConnection.saveGasTable(cubic, dateTime, userEmail, totalMonthValue);

            dbInputState = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void checkTotalMonth(String userEmail){
        double resultCubic;
        double cubic = Double.parseDouble(gasFields.get(ListValues.VALUE_ZERO.getValue()));
        String inputDate = dateFields.get(ListValues.VALUE_ZERO.getValue());
        String currentCubicString = gasFields.get(ListValues.VALUE_ZERO.getValue());
        double currentKwh = Double.parseDouble(currentCubicString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(inputDate + " 00:00", formatter); // Time 00:00 default value
        String formattedDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Gas gas = dbConnection.readGas(userEmail, LocalDateTime.parse(formattedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        if(gas == null){
            // default value
            resultCubic = 0.0;
        } else{
            resultCubic = currentKwh - gas.getM3();
        }
        saveGas(userEmail, resultCubic, cubic);
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
