package com.algaier.MeterReading.View.Gas;

import com.algaier.MeterReading.Controller.DashboardController;
import com.algaier.MeterReading.Controller.GasController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Window;

import javax.swing.*;
import java.util.ResourceBundle;

public class GasWindow extends Window {
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
    private static final String[] MENU_BUTTON_IDS = {"consumption", "overview", "back"};

    public GasWindow(ResourceBundle messages, DBConnect dbConnection) {
        super(POS_X, POS_Y);
        GasController gasController = new GasController(messages, dbConnection);
        CButton menuButton = new CButton(gasController, 3);

        String[] buttonNames = {
                messages.getString("new_consumption"),
                messages.getString("overview"),
                messages.getString("back")};

        menuButton.createButtonsGas(MENU_BUTTON_POS_X, MENU_BUTTON_POS_Y, MENU_BUTTON_POS_WIDTH, MENU_BUTTON_POS_HEIGHT, MENU_BUTTON_POS_DISTANCE, buttonNames, MENU_BUTTON_IDS, MENU_BUTTON_POS_POSITION);
        for(JButton button : menuButton.getButtons()){
            add(button);
        }

        setDbConnection(dbConnection);
        close();
        setVisible(true);
    }
}
