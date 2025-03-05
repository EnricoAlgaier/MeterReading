package com.algaier.MeterReading.Controller;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Controller.Services.SaveGasInput;
import com.algaier.MeterReading.Controller.Services.SaveWaterInput;
import com.algaier.MeterReading.Layout.Components.CCheckBox;
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
    private final String userEmail;
    private CCheckBox newMeterCheck;
    private String waterLocation;

    public WaterController(ResourceBundle messages, DBConnect dbConnection, WaterWindow waterWindow, String userEmail) {
        this.messages = messages;
        this.dbConnection = dbConnection;
        this.waterWindow = waterWindow;
        this.userEmail = userEmail;
    }

    public WaterController(ResourceBundle messages, Consumption consumption, CTextField cubicField, CTextField dateField, DBConnect dbConnection, String userEmail, CCheckBox newMeterCheck) {
        this.messages = messages;
        this.consumption = consumption;
        this.cubicField = cubicField;
        this.dateField = dateField;
        this.dbConnection = dbConnection;
        this.userEmail = userEmail;
        this.newMeterCheck = newMeterCheck;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonID = ((JButton) e.getSource()).getActionCommand();

        switch (buttonID) {
            case "consumption":
                new Consumption(messages, dbConnection, userEmail);
                break;

            case "overview":
                break;

            case "back":
                waterWindow.dispose();
                new Dashboard(messages, dbConnection, userEmail);
                break;

            case "save":
                double defaultMonthValue = 0.0;
                double newConsumptionValue = 0.0;

                SaveWaterInput saveWaterInput = new SaveWaterInput(dbConnection, cubicField, dateField);
                double totalMonthValue = 0;

                if (consumption.getCubicField().getText() != null && consumption.getDateField().getText() != null) {
                    saveWaterInput.setWaterTextInput(1);
                    saveWaterInput.setWaterDateTextInput(1);
                    saveWaterInput.checkTotalMonth(userEmail, consumption.getWaterType());

                    if (saveWaterInput.getDbInputState()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Erfolgreich eingetragen",
                                "Erfolgreich",
                                JOptionPane.INFORMATION_MESSAGE);
                        consumption.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Nicht alle Felder sind ausgefüllt",
                            "Achtung",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                if (newMeterCheck.isCheckBoxSelected()) {
                    saveWaterInput.setWaterTextInput(consumption.getTextFieldCount());
                    saveWaterInput.setWaterDateTextInput(consumption.getDateFieldCount());
                    saveWaterInput.saveWater(consumption.getWaterType(), userEmail, defaultMonthValue, newConsumptionValue);
                }
                break;

            case "cancel":
                consumption.dispose();
                break;

            case "cold":
                consumption.removeComponentsToWindow();
                consumption.createInputFields(cubicField, dateField, messages, "cold");
                consumption.createLabels(messages);
                consumption.repaint();
                break;

            case "hot":
                consumption.removeComponentsToWindow();
                consumption.createInputFields(cubicField, dateField, messages, "hot");
                consumption.createLabels(messages);
                consumption.repaint();
                break;

            default:
                break;
        }
    }

    public void setWaterLocation(String waterLocation){
        this.waterLocation = waterLocation;
    }
}