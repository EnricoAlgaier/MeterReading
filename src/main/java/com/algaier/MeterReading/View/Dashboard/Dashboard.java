package com.algaier.MeterReading.View.Dashboard;

import com.algaier.MeterReading.Controller.DashboardController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Window;

import javax.swing.*;
import java.util.ResourceBundle;
public class Dashboard extends Window {
    private static final int POS_X = 1500;
    private static final int POS_Y = 800;
    private DashboardController dashboardListener;
    private static DBConnect dbConnection;

    // Button properties
    private static final String[] BUTTON_ID = {"electricity", "gas", "water", "setprice","close"};
    private static final String POSITION = "posY";
    private static final int BUTTON_POS_X = 50;
    private static final int BUTTON_POS_Y = 20;
    private static final int HEIGHT = 50;
    private static final int WIDTH = 180;
    private static final int DISTANCE = 50;

    public Dashboard(ResourceBundle messages, DBConnect dbConnection) {
        super(POS_X, POS_Y);

        this.dbConnection = dbConnection;

        String[] BUTTON_NAMES = {
                messages.getString("electricity"),
                messages.getString("gas"),
                messages.getString("water"),
                messages.getString("setprice"),
                messages.getString("close")};

        dashboardListener = new DashboardController(this, messages, dbConnection);
        CButton menuButton = new CButton(dashboardListener, 5);

        menuButton.createButtons(BUTTON_POS_X, BUTTON_POS_Y, WIDTH, HEIGHT, DISTANCE, BUTTON_NAMES, BUTTON_ID, POSITION);
        for (JButton button : menuButton.getButtons()) {
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