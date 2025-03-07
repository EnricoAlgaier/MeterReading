package com.algaier.MeterReading.Controller;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ResourceBundle;

public class LocationRadioButtonListener implements ItemListener {
    public final WaterController waterController;
    public final ResourceBundle messages;

    public  LocationRadioButtonListener(WaterController waterController, ResourceBundle messages){
     this.waterController = waterController;
     this.messages = messages;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String radioButtonID = ((JRadioButton) e.getSource()).getActionCommand();

            switch (radioButtonID) {
                case "kitchen":
                    waterController.setWaterLocation(messages.getString("kitchen"));
                    break;

                case "bathroom":
                    waterController.setWaterLocation(messages.getString("bathroom"));
                    break;

                case "laundryRoom":
                    waterController.setWaterLocation(messages.getString("laundryRoom"));
                    break;

                case "garden":
                    waterController.setWaterLocation(messages.getString("garden"));
                    break;

                case "basement":
                    waterController.setWaterLocation(messages.getString("basement"));
                    break;

                case "centralMeter":
                    waterController.setWaterLocation(messages.getString("centralMeter"));
                    break;

                default:
                    break;
            }
        }
    }
}
