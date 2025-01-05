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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class DashboardController implements ActionListener {
    private Dashboard dashboard;
    private ResourceBundle messages;
    private DBConnect dbConnection;
    private CTextField priceConfigurationFields;
    private PriceConfiguration priceConfiguration;

    public DashboardController(Dashboard dashboard, ResourceBundle messages, DBConnect dbConnection) {
        this.dashboard = dashboard;
        this.messages = messages;
        this.dbConnection = dbConnection;
    }

    // PriceConfigurationGasWaterElectricity
    public DashboardController(PriceConfiguration priceConfiguration, ResourceBundle messages, DBConnect dbConnection, CTextField priceConfigurationFields) {
        this.priceConfiguration = priceConfiguration;
        this.messages = messages;
        this.dbConnection = dbConnection;
        this.priceConfigurationFields = priceConfigurationFields;
    }

    // PriceCOnfigurationGasWaterElectricitySaveFunction
    public DashboardController(PriceConfiguration priceConfiguration, CTextField priceConfigurationFields, DBConnect dbConnection) {
        this.priceConfigurationFields = priceConfigurationFields;
        this.priceConfiguration = priceConfiguration;
        this.dbConnection = dbConnection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonID = ((JButton) e.getSource()).getActionCommand();

        switch (buttonID) {
            case "electricity":
                dashboard.dispose();
                new ElectricityWindow(messages, dbConnection);
                break;

            case "gas":
                dashboard.dispose();
                new GasWindow(messages, dbConnection);
                break;

            case "water":
                dashboard.dispose();
                new WaterWindow(messages, dbConnection);
                break;

            case "setprice": // change to priceConfiguration
                new PriceConfiguration(messages, dbConnection);
                dashboard.dispose();
                break;

            case "close":
                Dashboard.closeWindow();
                break;

            case "cancel":
                break;

            case "configuration_gas":
                priceConfiguration.removeComponentsToWindow();
                String[] labelPriceConfigNameGas = new String[]{"price", "gas_basiscCosts"};
                priceConfiguration.setLabelPriceConfig(labelPriceConfigNameGas);
                priceConfiguration.createFields(priceConfigurationFields, messages, "gas");
                priceConfiguration.createLabels(messages);
                priceConfiguration.repaint();
                break;

            case "configuration_water":
                priceConfiguration.removeComponentsToWindow();
                String[] labelPriceConfigNameWater = new String[]{"price", "water_basiscCosts"};
                priceConfiguration.setLabelPriceConfig(labelPriceConfigNameWater);
                priceConfiguration.createFields(priceConfigurationFields, messages, "water");
                priceConfiguration.createLabels(messages);
                priceConfiguration.repaint();
                break;

            case "configuration_electricity":
                priceConfiguration.removeComponentsToWindow();
                String[] labelPriceConfigNameElectricity = new String[]{"electricity_price", "electricity_basiscCosts"};
                priceConfiguration.setLabelPriceConfig(labelPriceConfigNameElectricity);
                priceConfiguration.createFields(priceConfigurationFields, messages, "electricity");
                priceConfiguration.createLabels(messages);
                priceConfiguration.repaint();
                break;

            case "back":
                priceConfiguration.dispose();
                new Dashboard(messages, dbConnection);
                break;

            case "saveConfig":
                SavePriceInput savePriceInput = new SavePriceInput(dbConnection, priceConfigurationFields);
                savePriceInput.setPriceTextInput(priceConfiguration.getInputFieldsCount());
                savePriceInput.setProductValueName(priceConfiguration.getProductName());

                if (!savePriceInput.checkPriceFields()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Nicht alle Felder sind ausgefüllt",
                            "Achtung",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    savePriceInput.savePrice();
                    if (savePriceInput.getDbInputState()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Erfolgreich eingetragen",
                                "Erfolgreich",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                break;

            default:
                break;
        }
    }
}