package com.algaier.MeterReading.Controller;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.View.Dashboard.Dashboard;
import com.algaier.MeterReading.View.Dashboard.PriceConfiguration;
import com.algaier.MeterReading.View.Gas.GasWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class DashboardController implements ActionListener {
    private Dashboard dashboard;
    private ResourceBundle messages;
    private DBConnect dbConnection;

    public DashboardController(Dashboard dashboard, ResourceBundle messages, DBConnect dbConnection) {
        this.dashboard = dashboard;
        this.messages = messages;
        this.dbConnection = dbConnection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonID = ((JButton) e.getSource()).getActionCommand();

        switch (buttonID) {
            case "electricity":
                System.out.println(buttonID);
                break;

            case "gas":
                dashboard.dispose();
                new GasWindow(messages, dbConnection);

                break;

            case "water":
                System.out.println(buttonID);
                break;

            case "setprice":
                new PriceConfiguration(messages, this);
                break;

            case "close":
                Dashboard.closeWindow();
                break;

            default:
                break;
        }
    }
}
