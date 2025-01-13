package com.algaier.MeterReading.View.Electricity;

import com.algaier.MeterReading.Controller.ElectricityController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Components.CLabel;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Layout.Window;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Consumption extends Window {
    private final CTextField cubicField;
    private final CTextField dateField;

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
    private static final int CUBIC_FIELD_LABEL_DISTANCE = 70;
    private static final String CUBIC_FIELD_LABEL_POSITION = "posY";

    private static final int DATE_FIELD_POS_X = 50;
    private static final int DATE_FIELD_POS_Y = 120;
    private static final int DATE_FIELD_WIDTH = 120;
    private static final int DATE_FIELD_HEIGHT = 40;
    private static final int DATE_FIELD_DISTANCE = 0;
    private static final String DATE_FIELD_POSITION = "";

    private static final int SAVE_CANCEL_BUTTON_POS_X = 50;
    private static final int SAVE_CANCEL_BUTTON_POS_Y = 380;
    private static final int SAVE_CANCEL_BUTTON_WIDTH = 140;
    private static final int SAVE_CANCEL_BUTTON_HEIGHT = 40;
    private static final int SAVE_CANCEL_BUTTON_DISTANCE = 150;
    private static final String SAVE_CANCEL_BUTTON_POSITION = "posX";
    private static final String[] SAVE_CANCEL_BUTTON_IDS = {"save", "cancel"};

    private static final int TEXT_FIELD_COUNT = 1;
    private static final int LABEL_COUNT = 2;
    private static final int BUTTON_COUNT = 2;

    public Consumption(ResourceBundle messages, DBConnect dbConnection) {
        super(POS_X, POS_Y);
        cubicField = new CTextField(TEXT_FIELD_COUNT);
        dateField = new CTextField(TEXT_FIELD_COUNT);
        CLabel cubicFieldLabel = new CLabel(LABEL_COUNT);
        ElectricityController electricityController = new ElectricityController(messages, this, cubicField, dateField, dbConnection);
        CButton saveCancelButton = new CButton(electricityController, BUTTON_COUNT);

        String[] cubicLabelNames = {
                messages.getString("kwh"),
                messages.getString("date")};

        String[] saveCancelButtonNames = {
                messages.getString("save"),
                messages.getString("cancel")};

        cubicField.createTextFields(CUBIC_FIELD_POS_X, CUBIC_FIELD_POS_Y, CUBIC_FIELD_WIDTH, CUBIC_FIELD_HEIGHT, CUBIC_FIELD_DISTANCE, CUBIC_FIELD_POSITION);
        cubicFieldLabel.createLabels(CUBIC_FIELD_LABEL_POS_X, CUBIC_FIELD_LABEL_POS_Y, CUBIC_FIELD_LABEL_WIDTH, CUBIC_FIELD_LABEL_HEIGHT, CUBIC_FIELD_LABEL_DISTANCE, CUBIC_FIELD_LABEL_POSITION, cubicLabelNames);

        addComponentsToWindow(cubicField.getFields());
        addComponentsToWindow(cubicFieldLabel.getLabels());

        dateField.createTextFields(DATE_FIELD_POS_X, DATE_FIELD_POS_Y, DATE_FIELD_WIDTH, DATE_FIELD_HEIGHT, DATE_FIELD_DISTANCE, DATE_FIELD_POSITION);
        for (JTextField field : dateField.getFields()) {
            add(field);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDateTime dateTime = LocalDateTime.now();
            String formattedDate = dateTime.format(formatter);
            field.setText(formattedDate);
        }

        saveCancelButton.createButtons(SAVE_CANCEL_BUTTON_POS_X, SAVE_CANCEL_BUTTON_POS_Y, SAVE_CANCEL_BUTTON_WIDTH, SAVE_CANCEL_BUTTON_HEIGHT, SAVE_CANCEL_BUTTON_DISTANCE, saveCancelButtonNames, SAVE_CANCEL_BUTTON_IDS, SAVE_CANCEL_BUTTON_POSITION, electricityController);

        addComponentsToWindow(saveCancelButton.getButtons());

        setVisible(true);
    }

    private void addComponentsToWindow(JComponent... components) {
        for (JComponent component : components) {
            add(component);
        }
    }

    public CTextField getCubicField(){
        return cubicField;
    }

    public CTextField getDateField(){
        return dateField;
    }
}