package com.algaier.MeterReading.View.Dashboard;

import com.algaier.MeterReading.Controller.DashboardController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Window;
import com.algaier.MeterReading.Utils.ComponentBuilderDashboard;

import javax.swing.*;
import java.util.ResourceBundle;
public class Dashboard extends Window {
    private static final int POS_X = 1500;
    private static final int POS_Y = 800;
    private DashboardController dashboardListener;
    private static DBConnect dbConnection;


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

        menuButton.createButtons(ComponentBuilderDashboard.BUTTON_POS_X,
                ComponentBuilderDashboard.BUTTON_POS_Y,
                ComponentBuilderDashboard.BUTTON_WIDTH,
                ComponentBuilderDashboard.BUTTON_HEIGHT,
                ComponentBuilderDashboard.BUTTON_DISTANCE,
                BUTTON_NAMES, ComponentBuilderDashboard.BUTTON_DASHBOARD_ID,
                ComponentBuilderDashboard.BUTTON_POSITION);

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