package com.algaier.MeterReading.View.Electricity;

import com.algaier.MeterReading.Controller.DashboardController;
import com.algaier.MeterReading.Controller.ElectricityController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Components.CLabel;
import com.algaier.MeterReading.Layout.Window;
import com.algaier.MeterReading.Utils.ComponentBuilderElectricity;

import javax.swing.*;
import java.util.ResourceBundle;

public class ElectricityWindow extends Window {
    private static final int POS_X = 1500;
    private static final int POS_Y = 800;
    private DashboardController dashboardListener;
    private static DBConnect dbConnection;
    public ElectricityWindow(ResourceBundle messages, DBConnect dbConnection, String userEmail) {
        super(POS_X, POS_Y);
        int buttonCount = 4;

        ElectricityController electricityController = new ElectricityController(messages, dbConnection, this, userEmail);
        CButton menuButton = new CButton(electricityController, buttonCount);

        String[] buttonNames = {
                messages.getString("new_consumption"),
                messages.getString("overview"),
                messages.getString("statistics"),
                messages.getString("back")};

        menuButton.createButtons(
                ComponentBuilderElectricity.MENU_BUTTON_POS_X,
                ComponentBuilderElectricity.MENU_BUTTON_POS_Y,
                ComponentBuilderElectricity.MENU_BUTTON_POS_WIDTH,
                ComponentBuilderElectricity.MENU_BUTTON_POS_HEIGHT,
                ComponentBuilderElectricity.MENU_BUTTON_POS_DISTANCE,
                buttonNames,
                ComponentBuilderElectricity.MENU_BUTTON_IDS,
                ComponentBuilderElectricity.MENU_BUTTON_POS_POSITION,
                electricityController);

        addComponentsToWindow(menuButton.getButtons());

        setDbConnection(dbConnection);
        close();
        setVisible(true);
    }

    public void setLastThreeValueLabel(int count, String[] labelNames){
        CLabel overviewLabel = new CLabel(count);

        overviewLabel.createLabels(
                ComponentBuilderElectricity.OVERVIEW_LABEL_POS_X,
                ComponentBuilderElectricity.OVERVIEW_LABEL_POS_Y,
                ComponentBuilderElectricity.OVERVIEW_LABEL_POS_WIDTH,
                ComponentBuilderElectricity.OVERVIEW_LABEL_POS_HEIGHT,
                ComponentBuilderElectricity.OVERVIEW_LABEL_POS_DISTANCE,
                ComponentBuilderElectricity.OVERVIEW_LABEL_POS_POSITION,
                labelNames
        );
        addComponentsToWindow(overviewLabel.getLabels());
    }

    private void addComponentsToWindow(JComponent... components) {
        for (JComponent component : components) {
            add(component);
        }
    }

    public static void closeWindow() {
        Window.closeWindow(dbConnection);
    }

}
