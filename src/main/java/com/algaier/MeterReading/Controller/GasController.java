package com.algaier.MeterReading.Controller;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Controller.Services.SaveTableInputToDB;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.View.Gas.Consumption;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class GasController implements ActionListener {
    private final ResourceBundle messages;
    private CTextField cubicField;
    private DBConnect dbConnection;

    public GasController(ResourceBundle messages, DBConnect dbConnection){
        this.messages = messages;
        this.dbConnection = dbConnection;
    }

    public GasController(ResourceBundle messages, CTextField cubicField, DBConnect dbConnection){
        this.messages = messages;
        this.cubicField = cubicField;
        this.dbConnection = dbConnection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonID = ((JButton) e.getSource()).getActionCommand();

        switch (buttonID){
            case "consumption":
                new Consumption(messages, dbConnection);
                break;

            case "overview":
                break;

            case "back":
                break;

            case "save":
                SaveTableInputToDB saveTableInputToDB = new SaveTableInputToDB(dbConnection, cubicField);
                saveTableInputToDB.setGasTextInput(1);
                saveTableInputToDB.saveGas();
                break;

            case "cancel":
                break;

            default:
                break;
        }

    }
}