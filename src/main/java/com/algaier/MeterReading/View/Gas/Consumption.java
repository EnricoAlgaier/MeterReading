package com.algaier.MeterReading.View.Gas;

import com.algaier.MeterReading.Controller.GasController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Components.CLabel;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Layout.Window;

import javax.swing.*;
import java.util.ResourceBundle;

public class Consumption extends Window {
    private static final int POS_X = 500;
    private static final int POS_Y = 500;

    private static final int CUBIC_FIELD_POS_X = 50;
    private static final int CUBIC_FIELD_POS_Y = 50;
    private static final int CUBIC_FIELD_WIDTH = 30;
    private static final int CUBIC_FIELD_HEIGHT = 40;
    private static final int CUBIC_FIELD_DISTANCE = 0;
    private static final String CUBIC_FIELD_POSITION = "";

    private static final int CUBIC_FIELD_LABEL_POS_X = 50;
    private static final int CUBIC_FIELD_LABEL_POS_Y = 30;
    private static final int CUBIC_FIELD_LABEL_WIDTH = 100;
    private static final int CUBIC_FIELD_LABEL_HEIGHT = 40;
    private static final int CUBIC_FIELD_LABEL_DISTANCE = 0;
    private static final String CUBIC_FIELD_LABEL_POSITION = "";

    private static final int DATE_FIELD_POS_X = 50;
    private static final int DATE_FIELD_POS_Y = 50;
    private static final int DATE_FIELD_POS_WIDTH = 50;
    private static final int DATE_FIELD_POS_HEIGHT = 50;
    private static final int DATE_FIELD_POS_DISTANCE = 50;

    private static final int SAVE_CANCEL_BUTTON_POS_X = 50;
    private static final int SAVE_CANCEL_BUTTON_POS_Y = 380;
    private static final int SAVE_CANCEL_BUTTON_WIDTH = 140;
    private static final int SAVE_CANCEL_BUTTON_HEIGHT = 40;
    private static final int SAVE_CANCEL_BUTTON_DISTANCE = 150;
    private static final String SAVE_CANCEL_BUTTON_POSITION = "posX";
    private static final String[] SAVE_CANCEL_BUTTON_IDS = {"save", "cancel"};

    public Consumption(ResourceBundle messages, DBConnect dbConnection) {
        super(POS_X, POS_Y);
        CTextField cubicField = new CTextField(1);
        CLabel cubicFieldLabel = new CLabel(1);
        GasController gasController = new GasController(messages, cubicField, dbConnection);
        CButton saveCancelButton = new CButton(gasController, 2);

        String[] cubicLabelNames = {messages.getString("cubic")};
        String[] saveCancelButtonNames = {messages.getString("save"), messages.getString("cancel")};

        cubicField.createTextFields(CUBIC_FIELD_POS_X, CUBIC_FIELD_POS_Y, CUBIC_FIELD_WIDTH, CUBIC_FIELD_HEIGHT, CUBIC_FIELD_DISTANCE, CUBIC_FIELD_POSITION);
        for(JTextField field : cubicField.getFields()){
            add(field);
        }

        cubicFieldLabel.createLabels(CUBIC_FIELD_LABEL_POS_X, CUBIC_FIELD_LABEL_POS_Y, CUBIC_FIELD_LABEL_WIDTH, CUBIC_FIELD_LABEL_HEIGHT, CUBIC_FIELD_LABEL_DISTANCE, CUBIC_FIELD_LABEL_POSITION, cubicLabelNames);
        for(JLabel label : cubicFieldLabel.getLabels()){
            add(label);
        }

        saveCancelButton.createButtonsGas(SAVE_CANCEL_BUTTON_POS_X, SAVE_CANCEL_BUTTON_POS_Y, SAVE_CANCEL_BUTTON_WIDTH, SAVE_CANCEL_BUTTON_HEIGHT, SAVE_CANCEL_BUTTON_DISTANCE, saveCancelButtonNames, SAVE_CANCEL_BUTTON_IDS, SAVE_CANCEL_BUTTON_POSITION);
        for(JButton button : saveCancelButton.getButtons()){
            add(button);
        }

        setVisible(true);
    }
}