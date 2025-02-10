package com.algaier.MeterReading.Controller;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Controller.Services.SaveElectricityInput;
import com.algaier.MeterReading.Layout.Components.CCheckBox;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.View.Dashboard.Dashboard;
import com.algaier.MeterReading.View.Electricity.Consumption;
import com.algaier.MeterReading.View.Electricity.ElectricityWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ResourceBundle;

public class ElectricityController implements ActionListener {
    private final ResourceBundle messages;
    private ElectricityWindow electricityWindow;
    private CTextField cubicField;
    private CTextField dateField;
    private final DBConnect dbConnection;
    private Consumption consumption;
    private final String userEmail;
    private CCheckBox newMeterCheck;

    public ElectricityController(ResourceBundle messages, DBConnect dbConnection, ElectricityWindow electricityWindow, String userEmail) {
        this.messages = messages;
        this.dbConnection = dbConnection;
        this.electricityWindow = electricityWindow;
        this.userEmail = userEmail;
    }

    public ElectricityController(ResourceBundle messages, Consumption consumption, CTextField cubicField, CTextField dateField, DBConnect dbConnection, String userEmail, CCheckBox newMeterCheck) {
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
                electricityWindow.dispose();
                new Dashboard(messages, dbConnection, userEmail);
                break;

            case "save":
                int defaultMonthValue = 0;
                double newConsumptionValue = 0.0;
                SaveElectricityInput saveElectricityInput = new SaveElectricityInput(dbConnection, cubicField, dateField);

                if (consumption.getCubicField().getText() != null && consumption.getDateField().getText() != null) {
                    JOptionPane.showMessageDialog(
                            null,
                            messages.getString("userSuccess"),
                            messages.getString("success"),
                            JOptionPane.INFORMATION_MESSAGE);

                    saveElectricityInput.setElectricityTextInput(consumption.getFieldCount());
                    saveElectricityInput.setElectricityDateTextInput(consumption.getFieldCount());
                    saveElectricityInput.checkTotalMonth(userEmail);
                    consumption.dispose();

                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            messages.getString("userAttention"),
                            messages.getString("attention"),
                            JOptionPane.INFORMATION_MESSAGE);
                }

                if (newMeterCheck.isCheckBoxSelected()) {
                    saveElectricityInput.setElectricityTextInput(consumption.getFieldCount());
                    saveElectricityInput.setElectricityDateTextInput(consumption.getFieldCount());
                    saveElectricityInput.saveElectricity(userEmail, defaultMonthValue, newConsumptionValue);
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