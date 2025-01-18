package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Layout.Components.CTextField;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SavePriceInput {
    private final DBConnect dbConnection;
    private final CTextField priceConfigurationFields;
    private List<String> priceFields, dateFields;
    private boolean dbInputState = false;

    public SavePriceInput(DBConnect dbConnection, CTextField priceConfigurationFields) {
        this.dbConnection = dbConnection;
        this.priceConfigurationFields = priceConfigurationFields;
    }

    public void savePrice(String userEmail) {
        try {

            BigDecimal price = new BigDecimal(priceFields.get(0));
            BigDecimal basiscCosts = new BigDecimal(priceFields.get(1));
            BigDecimal abatement = new BigDecimal(priceFields.get(2));
            String product = priceFields.get(3);

            dbConnection.savePriceTable(price, product, basiscCosts, abatement, userEmail);

            dbInputState = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setPriceTextInput(int fieldCounter) {
        priceConfigurationFields.textInput(fieldCounter);
        priceFields = new ArrayList<>();
        priceFields = priceConfigurationFields.getText();
    }

    public boolean checkPriceFields() {
        int counter = 0;
        for (int i = 0; i < priceFields.size(); i++) {
            if (priceFields.get(i) == "" || priceFields.get(i) == null) {
                break;
            } else {
                if (counter == 3) {
                    return true;
                }
            }
            counter++;
        }
        return false;
    }

    public void setProductValueName(String productName){
        priceFields.add(productName);
    }

    public boolean getDbInputState() {
        return dbInputState;
    }

}
