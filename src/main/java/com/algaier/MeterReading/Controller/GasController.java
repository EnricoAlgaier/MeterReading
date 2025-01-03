package com.algaier.MeterReading.Controller;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Controller.Services.SaveTableInputToDB;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.View.Dashboard.Dashboard;
import com.algaier.MeterReading.View.Gas.Consumption;
import com.algaier.MeterReading.View.Gas.GasWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class GasController implements ActionListener {
    private ResourceBundle messages;
    private GasWindow gasWindow;
    private CTextField cubicField;
    private CTextField dateField;
    private DBConnect dbConnection;
    private Consumption consumption;

    public GasController(ResourceBundle messages, DBConnect dbConnection, GasWindow gasWindow) {
        this.messages = messages;
        this.dbConnection = dbConnection;
        this.gasWindow = gasWindow;
    }

    public GasController(ResourceBundle messages, Consumption consumption, CTextField cubicField, CTextField dateField, DBConnect dbConnection) {
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
                gasWindow.dispose();
                new Dashboard(messages, dbConnection);
                break;

            case "save":
                SaveTableInputToDB saveTableInputToDB = new SaveTableInputToDB(dbConnection, cubicField, dateField);

                if (consumption.getCubicField() != null && consumption.getDateField() != null) {
                    saveTableInputToDB.setGasTextInput(1);
                    saveTableInputToDB.setGasDateTextInput(1);
                    saveTableInputToDB.saveGas();

                    if (saveTableInputToDB.getDbInputState()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Erfolgreich eingetragen",
                                "Erfolgreich",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
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