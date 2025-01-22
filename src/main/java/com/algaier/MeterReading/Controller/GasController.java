package com.algaier.MeterReading.Controller;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Controller.Services.SaveGasInput;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Model.Price;
import com.algaier.MeterReading.View.Dashboard.Dashboard;
import com.algaier.MeterReading.View.Gas.Consumption;
import com.algaier.MeterReading.View.Gas.GasWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.ResourceBundle;

public class GasController implements ActionListener {
    private final ResourceBundle messages;
    private GasWindow gasWindow;
    private CTextField cubicField;
    private CTextField dateField;
    private final DBConnect dbConnection;
    private Consumption consumption;
    private final String userEmail;

    public GasController(ResourceBundle messages, DBConnect dbConnection, GasWindow gasWindow, String userEmail) {
        this.messages = messages;
        this.dbConnection = dbConnection;
        this.gasWindow = gasWindow;
        this.userEmail = userEmail;
    }

    public GasController(ResourceBundle messages, Consumption consumption, CTextField cubicField, CTextField dateField, DBConnect dbConnection, String userEmail) {
        this.messages = messages;
        this.consumption = consumption;
        this.cubicField = cubicField;
        this.dateField = dateField;
        this.dbConnection = dbConnection;
        this.userEmail = userEmail;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonID = ((JButton) e.getSource()).getActionCommand();

        switch (buttonID) {
            case "consumption":
                new Consumption(messages, dbConnection, userEmail);
                break;

            case "overview":
                List<String> gasList = dbConnection.readGasValues(userEmail);
                Price gasPriceValue = dbConnection.readPriceValue(userEmail, "gas");
                double totalCubic = Double.parseDouble(gasList.get(1));

                BigDecimal cubicValue = BigDecimal.valueOf(totalCubic);
                BigDecimal gasPrice = gasPriceValue.getPrice();
                BigDecimal result = cubicValue.multiply(gasPrice);

                for(String en : gasList){
                    System.out.println(en);
                }
System.out.println(result);
                break;

            case "back":
                gasWindow.dispose();
                new Dashboard(messages, dbConnection, userEmail);
                break;

            case "save":
                SaveGasInput saveTableInputToDB = new SaveGasInput(dbConnection, cubicField, dateField);

                if (consumption.getCubicField().getText() != null && consumption.getDateField().getText() != null) {
                    saveTableInputToDB.setGasTextInput(1);
                    saveTableInputToDB.setGasDateTextInput(1);
                    saveTableInputToDB.saveGas(userEmail);

                    if (saveTableInputToDB.getDbInputState()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Erfolgreich eingetragen",
                                "Erfolgreich",
                                JOptionPane.INFORMATION_MESSAGE);
                        consumption.dispose();
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