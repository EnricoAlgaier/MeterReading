package com.algaier.MeterReading.Controller;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Controller.Services.SaveGasInput;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.View.Dashboard.Dashboard;

import com.algaier.MeterReading.View.Water.Consumption;
import com.algaier.MeterReading.View.Water.WaterWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class WaterController implements ActionListener {
    private final ResourceBundle messages;
    private WaterWindow waterWindow;
    private CTextField cubicField;
    private CTextField dateField;
    private final DBConnect dbConnection;
    private Consumption consumption;

    public WaterController(ResourceBundle messages, DBConnect dbConnection, WaterWindow waterWindow) {
        this.messages = messages;
        this.dbConnection = dbConnection;
        this.waterWindow = waterWindow;
    }

    public WaterController(ResourceBundle messages, Consumption consumption, CTextField cubicField, CTextField dateField, DBConnect dbConnection) {
        this.messages = messages;
        this.consumption = consumption;
        this.cubicField = cubicField;
        this.dateField = dateField;
        this.dbConnection = dbConnection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonID = ((JButton) e.getSource()).getActionCommand();

        switch (buttonID) {
            case "consumption":
                new Consumption(messages, dbConnection);
                break;

            case "overview":
                break;

            case "back":
                waterWindow.dispose();
                new Dashboard(messages, dbConnection);
                break;

            case "save":
                SaveGasInput saveTableInputToDB = new SaveGasInput(dbConnection, cubicField, dateField);

                if (consumption.getCubicField().getText() != null && consumption.getDateField().getText() != null) {
                    saveTableInputToDB.setGasTextInput(1);
                    saveTableInputToDB.setGasDateTextInput(1);
                    saveTableInputToDB.saveGas();

                    if (saveTableInputToDB.getDbInputState()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Erfolgreich eingetragen",
                                "Erfolgreich",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else{
                    JOptionPane.showMessageDialog(
                            null,
                            "Nicht alle Felder sind ausgefüllt",
                            "Achtung",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            case "cancel":
                consumption.dispose();
                break;

            default:
                break;
        }
    }
}