package com.algaier.MeterReading.Controller;

import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.View.Dashboard.Dashboard;
import com.algaier.MeterReading.View.Dashboard.PriceConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class DashboardListener implements ActionListener {
    private Dashboard dashboard;
    private ResourceBundle messages;

    public DashboardListener(Dashboard dashboard, ResourceBundle messages) {
        this.dashboard = dashboard;
        this.messages = messages;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonID = ((JButton) e.getSource()).getActionCommand();

        switch (buttonID) {
            case "electricity":
                System.out.println(buttonID);
                break;

            case "gas":
                System.out.println(buttonID);
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
