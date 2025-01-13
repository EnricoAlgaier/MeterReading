package com.algaier.MeterReading.View.Water;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Controller.WaterController;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Components.CLabel;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Layout.Window;
import com.algaier.MeterReading.Utils.ComponentBuilderWater;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Consumption extends Window {
    private final CTextField cubicField;
    private final CTextField dateField;

    private static final int POS_X = 500;
    private static final int POS_Y = 500;

    private static final int TEXT_FIELD_COUNT = 2;
    private static final int DATE_FIELD_COUNT = 1;
    private static final int LABEL_COUNT = 3;
    private static final int BUTTON_COUNT = 2;

    private DBConnect dbConnection;
    private final CLabel cubicFieldLabel = new CLabel(LABEL_COUNT);

    public Consumption(ResourceBundle messages, DBConnect dbConnection) {
        super(POS_X, POS_Y);
        this.dbConnection = dbConnection;

        cubicField = new CTextField(TEXT_FIELD_COUNT);
        dateField = new CTextField(DATE_FIELD_COUNT);

        WaterController waterController = new WaterController(messages, this, cubicField, dateField, dbConnection);


        setVisible(true);
    }

    public void createLabels(ResourceBundle messages) {
        String[] cubicLabelNames = {
                messages.getString("cubic"),
                messages.getString("place"),
                messages.getString("date")};

        cubicFieldLabel.createLabels(
                ComponentBuilderWater.LABEL_POS_X,
                ComponentBuilderWater.LABEL_POS_Y,
                ComponentBuilderWater.LABEL_WIDTH,
                ComponentBuilderWater.LABEL_HEIGHT,
                ComponentBuilderWater.LABEL_DISTANCE,
                ComponentBuilderWater.LABEL_POSITION,
                cubicLabelNames);


        addComponentsToWindow(cubicFieldLabel.getLabels());
    }

    public void createInputFields(CTextField inputFields, ResourceBundle messages, String waterType) {
        cubicField.createTextFields(
                ComponentBuilderWater.FIELD_POS_X,
                ComponentBuilderWater.FIELD_POS_Y,
                ComponentBuilderWater.FIELD_WIDTH,
                ComponentBuilderWater.FIELD_HEIGHT,
                ComponentBuilderWater.FIELD_DISTANCE,
                ComponentBuilderWater.FIELD_POSITION);

        dateField.createTextFields(
                ComponentBuilderWater.DATE_FIELD_POS_X,
                ComponentBuilderWater.DATE_FIELD_POS_Y,
                ComponentBuilderWater.DATE_FIELD_WIDTH,
                ComponentBuilderWater.DATE_FIELD_HEIGHT,
                ComponentBuilderWater.DATE_FIELD_DISTANCE,
                ComponentBuilderWater.DATE_FIELD_POSITION);

        addComponentsToWindow(cubicField.getFields());
        for (JTextField field : dateField.getFields()) {
            add(field);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDateTime dateTime = LocalDateTime.now();
            String formattedDate = dateTime.format(formatter);
            field.setText(formattedDate);
        }

        createSaveButton(inputFields, messages, waterType);
    }

    private void createSaveButton(CTextField inputFields, ResourceBundle messages, String waterType){
        WaterController waterController = new WaterController(messages, this, cubicField, dateField, dbConnection);
        CButton saveCancelButton = new CButton(waterController, BUTTON_COUNT);

        String[] saveCancelButtonNames = {
                messages.getString("save"),
                messages.getString("cancel")};

        saveCancelButton.createButtons(
                ComponentBuilderWater.BUTTON_POS_X,
                ComponentBuilderWater.BUTTON_POS_Y,
                ComponentBuilderWater.BUTTON_WIDTH,
                ComponentBuilderWater.BUTTON_HEIGHT,
                ComponentBuilderWater.BUTTON_DISTANCE,
                saveCancelButtonNames,
                ComponentBuilderWater.SAVE_CANCEL_BUTTON_IDS,
                ComponentBuilderWater.BUTTON_POSITION,
                waterController);

        addComponentsToWindow(saveCancelButton.getButtons());
    }

    private void addComponentsToWindow(JComponent... components) {
        for (JComponent component : components) {
            add(component);
        }
    }

    public CTextField getCubicField() {
        return cubicField;
    }

    public CTextField getDateField() {
        return dateField;
    }
}