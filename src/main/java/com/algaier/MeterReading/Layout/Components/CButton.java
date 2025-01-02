package com.algaier.MeterReading.Layout.Components;

import com.algaier.MeterReading.Controller.DashboardListener;
import com.algaier.MeterReading.Layout.Design.CustomButtonRect;

import java.awt.*;

public class CButton {
    private String buttonColor1 = "#000000"; //default Color
    private String buttonColor2 = "#001133"; //default Color
    private final String buttonFont = "Arial";
    private final int fontSize = 15;

    private CustomButtonRect[] buttons;
    private DashboardListener dashboardListener;
    private int buttonCount;

    //Dashboard Button
    public CButton(DashboardListener dashboardListener, int buttonCount) {
        this.dashboardListener = dashboardListener;
        this.buttonCount = buttonCount;
        buttons = new CustomButtonRect[buttonCount];
    }

    public void createButtons(int posX, int posY, int width, int height, int distance, String[] buttonNames,
                              String[] buttonID, String position) {
        for (int createButton = 0; createButton < buttonCount; createButton++) {
            buttons[createButton] = new CustomButtonRect(buttonColor1, buttonColor2, buttonNames[createButton]);
            buttons[createButton].setBounds(posX, posY, width, height);
            buttons[createButton].addActionListener(dashboardListener);
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