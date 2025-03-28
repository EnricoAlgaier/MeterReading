package com.algaier.MeterReading.View.Dashboard;

import com.algaier.MeterReading.Controller.DashboardController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Window;
import com.algaier.MeterReading.Utils.ComponentBuilderDashboard;
import com.algaier.MeterReading.View.Electricity.Overview;

import javax.swing.*;
import java.util.ResourceBundle;
public class Dashboard extends Window {
    private static final int POS_X = 1500;
    private static final int POS_Y = 800;
    private static DBConnect dbConnection;
    private String userEmail;

    public Dashboard(ResourceBundle messages, DBConnect dbConnection, String userEmail) {
        super(POS_X, POS_Y);
        Dashboard.dbConnection = dbConnection;
        new Overview(dbConnection, userEmail);
        String[] BUTTON_NAMES = {
                messages.getString("electricity"),
                messages.getString("gas"),
                messages.getString("water"),
                messages.getString("setprice"),
                messages.getString("close")};

        DashboardController dashboardController = new DashboardController(this, messages, dbConnection, userEmail);
        CButton menuButton = new CButton(dashboardController, 5);

        menuButton.createButtons(ComponentBuilderDashboard.BUTTON_POS_X,
                ComponentBuilderDashboard.BUTTON_POS_Y,
                ComponentBuilderDashboard.BUTTON_WIDTH,
                ComponentBuilderDashboard.BUTTON_HEIGHT,
                ComponentBuilderDashboard.BUTTON_DISTANCE,
                BUTTON_NAMES, ComponentBuilderDashboard.BUTTON_DASHBOARD_ID,
                ComponentBuilderDashboard.BUTTON_POSITION,
                dashboardController);

        addComponentsToWindow(menuButton.getButtons());
        setDbConnection(dbConnection);
        close();
        setVisible(true);
    }

    public static void closeWindow() {
        Window.closeWindow(dbConnection);
    }

    private void addComponentsToWindow(JComponent... components) {
        for (JComponent component : components) {
            add(component);
        }
    }
}