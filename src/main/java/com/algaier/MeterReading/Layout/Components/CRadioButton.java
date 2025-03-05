package com.algaier.MeterReading.Layout.Components;

import com.algaier.MeterReading.View.Water.Consumption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;

public class CRadioButton {
    private final JRadioButton[] radioButtons;
    private final ButtonGroup buttonGroup; // Nur eine ButtonGroup für alle RadioButtons
    private final int count;
    private static final String BACKGROUNDCOLOR_CODE = "#2b2d30";
    private static final Color BACKGROUNDCOLOR = Color.decode(BACKGROUNDCOLOR_CODE);

    public CRadioButton(Consumption waterController, int count) {
        this.count = count;
        radioButtons = new JRadioButton[count];
        buttonGroup = new ButtonGroup(); // Eine gemeinsame ButtonGroup für alle Buttons
    }

    public void createRadioButtons(int posX, int posY, int width, int height, int distance, String position, String[] radioIds, ItemListener listener) {
        for (int i = 0; i < count; i++) {
            radioButtons[i] = new JRadioButton();
            radioButtons[i].setBounds(posX, posY, width, height);
            radioButtons[i].addItemListener(listener);
            radioButtons[i].setActionCommand(radioIds[i]);
            radioButtons[i].setFocusPainted(false);
            radioButtons[i].setBackground(BACKGROUNDCOLOR);
            radioButtons[i].setForeground(Color.WHITE);

            buttonGroup.add(radioButtons[i]);

            if (position.equals("posX")) {
                posX += distance;
            } else if (position.equals("posY")) {
                posY += distance;
            }
        }
    }

    public JRadioButton[] getRadioButtons() {
        return radioButtons;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }
}
