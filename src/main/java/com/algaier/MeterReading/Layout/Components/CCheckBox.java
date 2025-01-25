package com.algaier.MeterReading.Layout.Components;

import javax.swing.*;

public class CCheckBox {
    private JCheckBox checkbox;

    public CCheckBox() {
    }

    public void createCCheckBox(int posX, int posY, int width, int height) {
        checkbox = new JCheckBox();
        checkbox.setBounds(posX, posY, width, height);
        checkbox.setContentAreaFilled(false);
        checkbox.setBorderPainted(false);
    }

    public JCheckBox getCCheckBox() {
        return checkbox;
    }

    public boolean isCheckBoxSelected() {
        return checkbox.isSelected();
    }
}