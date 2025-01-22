package com.algaier.MeterReading.Controller;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Controller.Services.SavePriceInput;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.View.Dashboard.Dashboard;
import com.algaier.MeterReading.View.Dashboard.PriceConfiguration;
import com.algaier.MeterReading.View.Electricity.ElectricityWindow;
import com.algaier.MeterReading.View.Gas.GasWindow;
import com.algaier.MeterReading.View.Water.WaterWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements ActionListener {
    private Dashboard dashboard;
    private final ResourceBundle messages;
    private final DBConnect dbConnection;
    private CTextField priceConfigurationFields;
    private PriceConfiguration priceConfiguration;
    private final String userEmail;

    public DashboardController(Dashboard dashboard, ResourceBundle messages, DBConnect dbConnection, String userEmail) {
        this.dashboard = dashboard;
        this.messages = messages;
        this.dbConnection = dbConnection;
        this.userEmail = userEmail;
    }

    // PriceConfigurationGasWaterElectricitySaveFunction
    public DashboardController(PriceConfiguration priceConfiguration, ResourceBundle messages, CTextField priceConfigurationFields, DBConnect dbConnection, String userEmail) {
        this.priceConfigurationFields = priceConfigurationFields;
        this.priceConfiguration = priceConfiguration;
        this.dbConnection = dbConnection;
        this.messages = messages;
        this.userEmail = userEmail;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonID = ((JButton) e.getSource()).getActionCommand();

        switch (buttonID) {
            case "electricity":
                dashboard.dispose();
                new ElectricityWindow(messages, dbConnection, userEmail);
                break;

            case "gas":
                dashboard.dispose();
                new GasWindow(messages, dbConnection, userEmail);
                break;

            case "water":
                dashboard.dispose();
                new WaterWindow(messages, dbConnection, userEmail);
                break;

            case "setprice":
                new PriceConfiguration(messages, dbConnection, userEmail);
                dashboard.dispose();
                break;

            case "close":
                Dashboard.closeWindow();
                break;

            case "cancel":
                break;

            case "configuration_gas":
                createInputFieldButtonLabel(priceConfiguration, "price", "gas_basiscCosts", messages, dbConnection,
                        "water", userEmail);
                break;

            case "configuration_water":
                createInputFieldButtonLabel(priceConfiguration, "price", "water_basiscCosts", messages, dbConnection,
                        "water", userEmail);
                break;

            case "configuration_electricity":
                createInputFieldButtonLabel(priceConfiguration, "electricity_price", "electricity_basiscCosts", messages, dbConnection,
                        "electricity", userEmail);
                break;

            case "back":
                priceConfiguration.dispose();
                new Dashboard(messages, dbConnection, userEmail);
                break;

            case "save":
                SavePriceInput savePriceInput = new SavePriceInput(dbConnection, priceConfigurationFields);
                savePriceInput.setPriceTextInput(priceConfiguration.getInputFieldsCount());
                savePriceInput.setProductValueName(priceConfiguration.getProductName());

                if (savePriceInput.checkPriceFields()) {
                    savePriceInput.saveOrUpdatePrice(userEmail, priceConfiguration.getProductName());
                    if (savePriceInput.getDbInputState()) {
                        JOptionPane.showMessageDialog(
                                null,
                                messages.getString("userSuccess"),
                                messages.getString("success"),
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    priceConfiguration.removeComponentsToWindow();
                    priceConfiguration.createFields(priceConfigurationFields, messages, priceConfiguration.getProductName());
                    priceConfiguration.createLabels(messages);
                    priceConfiguration.repaint();
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            messages.getString("userAttention"),
                            messages.getString("attention"),
                            JOptionPane.INFORMATION_MESSAGE);
                }
                break;

            default:
                break;
        }
    }

    private void createInputFieldButtonLabel(PriceConfiguration priceConfiguration, String labelName1, String labelName2, ResourceBundle messages, DBConnect dbConnect,
                                             String productName, String userEmail){
        priceConfiguration.removeComponentsToWindow();
        String[] labelPriceConfigNameElectricity = new String[]{labelName1, labelName2};
        priceConfiguration.setLabelPriceConfig(labelPriceConfigNameElectricity);
        priceConfiguration.createFields(priceConfigurationFields, messages, productName);
        priceConfiguration.createLabels(messages);
        loadPriceTable(priceConfiguration, dbConnection, priceConfigurationFields, userEmail, priceConfiguration.getProductName());
        priceConfiguration.repaint();
    }

    private void loadPriceTable(PriceConfiguration priceConfiguration, DBConnect dbConnect, CTextField input, String userMail, String productName) {
        dbConnect.readPriceValues(userMail, productName);
        List<BigDecimal> priceList = dbConnect.getPriceList();
        List<String> stringList = new ArrayList<>();

        for (BigDecimal bigDecimal : priceList) {
            stringList.add(bigDecimal.toPlainString());
            if (stringList.size() == 3) {
                priceConfiguration.setPriceToInputFields(input, stringList);
                stringList.clear();
            }
        }

        if (!stringList.isEmpty()) {
            priceConfiguration.setPriceToInputFields(input, stringList);
        } else {
            System.out.println("d");
        }
    }
}