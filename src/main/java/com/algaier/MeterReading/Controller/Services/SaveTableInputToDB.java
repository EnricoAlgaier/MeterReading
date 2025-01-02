package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Layout.Components.CTextField;

import java.util.ArrayList;
import java.util.List;

public class SaveTableInputToDB {
    private DBConnect dbConnection;
    private CTextField gasField;
    private List<String> gasFields;

    public SaveTableInputToDB(DBConnect dbConnection, CTextField gasField){
        this.dbConnection = dbConnection;
        this.gasField = gasField;
    }

    public void saveGas(){
        System.out.println(gasFields.get(0));
       // double t = gasFields(0); // Convert to Double


        try {
            //dbConnection.saveDbTableInput(cubic);

        } catch (Exception ex){

        }
    }

    public void setGasTextInput(int fieldCounter) {
        gasField.textInput(fieldCounter);
        gasFields = new ArrayList<>();
        gasFields = gasField.getText();
    }
}
