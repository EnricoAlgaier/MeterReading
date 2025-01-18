package com.algaier.MeterReading.View.Electricity;

import com.algaier.MeterReading.Controller.DashboardController;
import com.algaier.MeterReading.Controller.ElectricityController;
import com.algaier.MeterReading.Controller.GasController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Window;

import javax.swing.*;
import java.util.ResourceBundle;

public class ElectricityWindow extends Window {
    private static final int POS_X = 1500;
    private static final int POS_Y = 800;
    private DashboardController dashboardListener;
    private static DBConnect dbConnection;

    private static final int MENU_BUTTON_POS_X = 50;
    private static final int MENU_BUTTON_POS_Y = 50;
    private static final int MENU_BUTTON_POS_WIDTH = 180;
    private static final int MENU_BUTTON_POS_HEIGHT = 50;
    private static final int MENU_BUTTON_POS_DISTANCE = 50;
    private static final String MENU_BUTTON_POS_POSITION = "posY";
    private static final String[] MENU_BUTTON_IDS = {"consumption", "overview", "statistics", "back"};

    private static final int BUTTON_COUNT = 4;

    private final String userEmail;

    public ElectricityWindow(ResourceBundle messages, DBConnect dbConnection, String userEmail) {
        super(POS_X, POS_Y);
        this.userEmail = userEmail;
        ElectricityController electricityController = new ElectricityController(messages, dbConnection, this, userEmail);
        CButton menuButton = new CButton(electricityController, BUTTON_COUNT);

        String[] buttonNames = {
                messages.getString("new_consumption"),
                messages.getString("overview"),
                messages.getString("statistics"),
                messages.getString("back")};

        menuButton.createButtons(MENU_BUTTON_POS_X, MENU_BUTTON_POS_Y, MENU_BUTTON_POS_WIDTH, MENU_BUTTON_POS_HEIGHT, MENU_BUTTON_POS_DISTANCE, buttonNames, MENU_BUTTON_IDS, MENU_BUTTON_POS_POSITION, electricityController);
        for(JButton button : menuButton.getButtons()){
            add(button);
        }

        setDbConnection(dbConnection);
        close();
        setVisible(true);
    }

    public static void closeWindow() {
        Window.closeWindow(dbConnection);
    }

}
