package com.algaier.MeterReading.View.Dashboard;

import com.algaier.MeterReading.Controller.DashboardController;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Components.CLabel;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Layout.Window;

import javax.swing.*;
import java.util.ResourceBundle;

public class PriceConfiguration extends Window {

    private JRadioButton warmWaterSelection;

    private static final int WINDOW_POS_X = 500;
    private static final int WINDOW_POS_Y = 500;

    private static final int INPUT_FIELD_POS_X = 50;
    private static final int INPUT_FIELD_POS_Y = 60;
    private static final int INPUT_FIELD_WIDTH = 100;
    private static final int INPUT_FIELD_HEIGHT = 40;
    private static final int INPUT_FIELD_DISTANCE = 100;
    private static final String INPUT_FIELD_POSITION = "posY";

    private static final int INPUT_FIELD_LABEL_POS_X = 50;
    private static final int INPUT_FIELD_LABEL_POS_Y = 30;
    private static final int INPUT_FIELD_LABEL_WIDTH = 200;
    private static final int INPUT_FIELD_LABEL_HEIGHT = 40;
    private static final int INPUT_FIELD_LABEL_DISTANCE = 100;
    private static final String INPUT_FIELD_LABEL_POSITION = "posY";

    private static final int SAVE_CANCEL_BUTTON_POS_X = 50;
    private static final int SAVE_CANCEL_BUTTON_POS_Y = 380;
    private static final int SAVE_CANCEL_BUTTON_WIDTH = 150;
    private static final int SAVE_CANCEL_BUTTON_HEIGHT = 40;
    private static final int SAVE_CANCEL_BUTTON_DISTANCE = 160;
    private static final String[] SAVE_CANCEL_BUTTON_IDS = {"save", "cancel"};
    private static final String SAVE_CANCEL_BUTTON_POSITION = "posX";

    private static final int counter = 3;

    public PriceConfiguration(ResourceBundle messages, DashboardController dashboardListener) {
        super(WINDOW_POS_X, WINDOW_POS_Y);
        CTextField inputFields = new CTextField(counter);
        CLabel inputLabel = new CLabel(counter);
        CButton saveCancelButton = new CButton(dashboardListener,2);

        String[] labelNames = {
                messages.getString("cost_electricity"),
                messages.getString("cost_gas"),
                messages.getString("cost_water")};

        String[] saveCancelButtonNames = {
                messages.getString("save"),
                messages.getString("cancel")};

        inputFields.createTextFields(INPUT_FIELD_POS_X, INPUT_FIELD_POS_Y, INPUT_FIELD_WIDTH, INPUT_FIELD_HEIGHT, INPUT_FIELD_DISTANCE, INPUT_FIELD_POSITION);
        for (JTextField field : inputFields.getFields()) {
            add(field);
        }

        inputLabel.createLabels(INPUT_FIELD_LABEL_POS_X, INPUT_FIELD_LABEL_POS_Y, INPUT_FIELD_LABEL_WIDTH, INPUT_FIELD_LABEL_HEIGHT, INPUT_FIELD_LABEL_DISTANCE, INPUT_FIELD_LABEL_POSITION, labelNames);
        for(JLabel label : inputLabel.getLabels()){
            add(label);
        }

        saveCancelButton.createButtons(SAVE_CANCEL_BUTTON_POS_X, SAVE_CANCEL_BUTTON_POS_Y, SAVE_CANCEL_BUTTON_WIDTH, SAVE_CANCEL_BUTTON_HEIGHT, SAVE_CANCEL_BUTTON_DISTANCE, saveCancelButtonNames, SAVE_CANCEL_BUTTON_IDS, SAVE_CANCEL_BUTTON_POSITION);
        for(JButton button : saveCancelButton.getButtons()){
            add(button);
        }

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }
}