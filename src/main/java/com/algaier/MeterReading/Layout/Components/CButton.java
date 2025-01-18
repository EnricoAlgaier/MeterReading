package com.algaier.MeterReading.Layout.Components;

import com.algaier.MeterReading.Controller.*;
import com.algaier.MeterReading.Layout.Design.CustomButtonRect;

import java.awt.*;
import java.awt.event.ActionListener;

public class CButton {
    private String buttonColor1 = "#000000"; //default Color
    private String buttonColor2 = "#001133"; //default Color
    private final String buttonFont = "Arial";
    private final int fontSize = 15;

    // Controller
    private DashboardController dashboardListener;
    private GasController gasController;
    private WaterController waterController;
    private ElectricityController electricityController;
    private LoginController loginController;

    private final CustomButtonRect[] buttons;
    private int buttonCount;

    // Dashboard Button
    public CButton(DashboardController dashboardListener, int buttonCount) {
        this.dashboardListener = dashboardListener;
        this.buttonCount = buttonCount;
        buttons = new CustomButtonRect[buttonCount];
    }

    // Gas Button
    public CButton(GasController gasController, int buttonCount) {
        this.gasController = gasController;
        this.buttonCount = buttonCount;
        buttons = new CustomButtonRect[buttonCount];
    }

    // Water Button
    public CButton(WaterController waterController, int buttonCount) {
        this.waterController = waterController;
        this.buttonCount = buttonCount;
        buttons = new CustomButtonRect[buttonCount];
    }

    // Electricity Button
    public CButton(ElectricityController electricityController, int buttonCount) {
        this.electricityController = electricityController;
        this.buttonCount = buttonCount;
        buttons = new CustomButtonRect[buttonCount];
    }

    // Login Button
    public CButton(LoginController loginController, int buttonCount) {
        this.loginController = loginController;
        this.buttonCount = buttonCount;
        buttons = new CustomButtonRect[buttonCount];
    }

    public void createButtons(int posX, int posY, int width, int height, int distance, String[] buttonNames,
                              String[] buttonID, String position, ActionListener listener) {
        for (int createButton = 0; createButton < buttonCount; createButton++) {
            buttons[createButton] = new CustomButtonRect(buttonColor1, buttonColor2, buttonNames[createButton]);
            buttons[createButton].setBounds(posX, posY, width, height);
            buttons[createButton].addActionListener(listener);
            buttons[createButton].setActionCommand(buttonID[createButton]);
            buttons[createButton].setFocusable(false);
            buttons[createButton].setFont(new Font(buttonFont, Font.PLAIN, fontSize));

            if (position.equals("posX")) {
                posX += distance;

            } else if (position.equals("posY")) {
                posY += distance;
            }
        }
    }

    public CustomButtonRect[] getButtons() {
        return buttons;
    }

    public void setButtonColor1(String buttonColor1) {
        this.buttonColor1 = buttonColor1;
    }

    public void setButtonColor2(String buttonColor2) {
        this.buttonColor2 = buttonColor2;
    }
}