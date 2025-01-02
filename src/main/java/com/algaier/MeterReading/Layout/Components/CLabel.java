package com.algaier.MeterReading.Layout.Components;

import javax.swing.*;
import java.awt.*;

public class CLabel {
    private int labelCount;
    private JLabel[] labels;
    private final String textColorCode = "#FFFFFF";
    private final int textSize = 15;
    private final Font textFont = new Font("Arial", Font.PLAIN, textSize);
    private final Color textColor = Color.decode(textColorCode);

    public CLabel(int labelCount){
        this.labelCount = labelCount;
        labels = new JLabel[labelCount];
    }

    public void createLabels(int posX, int posY, int width, int height, int distance, String position, String[] labelNames){
        for(int createLabel = 0; createLabel < labelCount; createLabel++){
            labels[createLabel] = new JLabel(labelNames[createLabel]);
            labels[createLabel].setBounds(posX, posY, width, height);
            labels[createLabel].setForeground(textColor);
            labels[createLabel].setFont(textFont);

            if (position.equals("posX")) {
                posX += distance;

            } else if (position.equals("posY")) {
                posY += distance;
            }
        }
    }

    public JLabel[] getLabels(){
        return labels;
    }
}
