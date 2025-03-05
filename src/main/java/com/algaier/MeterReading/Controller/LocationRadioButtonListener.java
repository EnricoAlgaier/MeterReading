package com.algaier.MeterReading.Controller;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LocationRadioButtonListener implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
        String radioButtonID = ((JRadioButton) e.getSource()).getActionCommand();

       switch(radioButtonID){
           case "kitchen":
               System.out.println("küche");
               break;

           case "bathroom":
               break;

           case "laundryRoom":
               break;

           case "garden":
               break;

           case "basement":
               break;

           case "centralMeter":
               break;

           default:
               break;
       }
    }
}
