package com.algaier.MeterReading.View.Dashboard;

import com.algaier.MeterReading.Controller.DashboardListener;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.LanguageManager;
import com.algaier.MeterReading.Layout.Window;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Dashboard extends Window {
    private static final int POSX = 1500;
    private static final int POSY = 800;
    private DashboardListener dashboardListener;

    private static final LanguageManager languageManager = new LanguageManager();
    private static final Locale locale = languageManager.getLocaleLanguage();
    private static final ResourceBundle messages = ResourceBundle.getBundle("messages", locale);

    // Button properties
    private static final String[] BUTTON_NAMES = {messages.getString("electricity"), messages.getString("gas"), messages.getString("water"), messages.getString("exit")};
    private static final String[] BUTTON_ID = {"electricity", "gas", "water", "exit"};
    private static final String POSITION = "posY";
    private static final int POS_X = 50;
    private static final int POS_Y = 20;
    private static final int HEIGHT = 50;
    private static final int WIDTH = 120;
    private static final int DISTANCE = 50;

    public Dashboard() {
        super(POSX, POSY);
        CButton menuButton = new CButton(dashboardListener, 4);

        menuButton.createButtons(POS_X, POS_Y, WIDTH, HEIGHT, DISTANCE, BUTTON_NAMES, BUTTON_ID, POSITION);
        for(JButton button : menuButton.getButtons()){
            add(button);
        }


        setVisible(true);
    }
}