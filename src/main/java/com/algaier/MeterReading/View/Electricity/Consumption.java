package com.algaier.MeterReading.View.Electricity;

import com.algaier.MeterReading.Controller.ElectricityController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Components.CCheckBox;
import com.algaier.MeterReading.Layout.Components.CLabel;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Layout.Window;
import com.algaier.MeterReading.Utils.ComponentBuilderElectricity;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Consumption extends Window {
    private final CTextField cubicField;
    private final CTextField dateField;

    private static final int POS_X = 500;
    private static final int POS_Y = 500;

    private static final int TEXT_FIELD_COUNT = 1;
    private static final int LABEL_COUNT = 2;
    private static final int BUTTON_COUNT = 2;
    private static final int NEW_METER_READER_LABEL_COUNT = 1;

    public Consumption(ResourceBundle messages, DBConnect dbConnection, String userEmail) {
        super(POS_X, POS_Y);

        cubicField = new CTextField(TEXT_FIELD_COUNT);
        dateField = new CTextField(TEXT_FIELD_COUNT);
        CLabel cubicFieldLabel = new CLabel(LABEL_COUNT);
        CLabel newMeterReaderLabel = new CLabel(NEW_METER_READER_LABEL_COUNT);
        CCheckBox newMeterReaderCheck = new CCheckBox();
        ElectricityController electricityController = new ElectricityController(messages, this, cubicField, dateField, dbConnection, userEmail, newMeterReaderCheck);
        CButton saveCancelButton = new CButton(electricityController, BUTTON_COUNT);

        String[] cubicLabelNames = {
                messages.getString("kwh"),
                messages.getString("date")};

        String[] saveCancelButtonNames = {
                messages.getString("save"),
                messages.getString("cancel")};

        String[] newMeterReaderLabelNames = {
                messages.getString("newMeterReaderLabel")
        };

        cubicField.createTextFields(
                ComponentBuilderElectricity.CUBIC_FIELD_POS_X,
                ComponentBuilderElectricity.CUBIC_FIELD_POS_Y,
                ComponentBuilderElectricity.CUBIC_FIELD_WIDTH,
                ComponentBuilderElectricity.CUBIC_FIELD_HEIGHT,
                ComponentBuilderElectricity.CUBIC_FIELD_DISTANCE,
                ComponentBuilderElectricity.CUBIC_FIELD_POSITION);

        cubicFieldLabel.createLabels(
                ComponentBuilderElectricity.CUBIC_FIELD_LABEL_POS_X,
                ComponentBuilderElectricity.CUBIC_FIELD_LABEL_POS_Y,
                ComponentBuilderElectricity.CUBIC_FIELD_LABEL_WIDTH,
                ComponentBuilderElectricity.CUBIC_FIELD_LABEL_HEIGHT,
                ComponentBuilderElectricity.CUBIC_FIELD_LABEL_DISTANCE,
                ComponentBuilderElectricity.CUBIC_FIELD_LABEL_POSITION,
                cubicLabelNames);

        dateField.createTextFields(
                ComponentBuilderElectricity.DATE_FIELD_POS_X,
                ComponentBuilderElectricity.DATE_FIELD_POS_Y,
                ComponentBuilderElectricity.DATE_FIELD_WIDTH,
                ComponentBuilderElectricity.DATE_FIELD_HEIGHT,
                ComponentBuilderElectricity.DATE_FIELD_DISTANCE,
                ComponentBuilderElectricity.DATE_FIELD_POSITION);

        for (JTextField field : dateField.getFields()) {
            add(field);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDateTime dateTime = LocalDateTime.now();
            String formattedDate = dateTime.format(formatter);
            field.setText(formattedDate);
        }

        saveCancelButton.createButtons(
                ComponentBuilderElectricity.SAVE_CANCEL_BUTTON_POS_X,
                ComponentBuilderElectricity.SAVE_CANCEL_BUTTON_POS_Y,
                ComponentBuilderElectricity.SAVE_CANCEL_BUTTON_WIDTH,
                ComponentBuilderElectricity.SAVE_CANCEL_BUTTON_HEIGHT,
                ComponentBuilderElectricity.SAVE_CANCEL_BUTTON_DISTANCE,
                saveCancelButtonNames,
                ComponentBuilderElectricity.SAVE_CANCEL_BUTTON_IDS,
                ComponentBuilderElectricity.SAVE_CANCEL_BUTTON_POSITION,
                electricityController);

        newMeterReaderCheck.createCCheckBox(
                ComponentBuilderElectricity.NEW_METER_CHECK_POS_X,
                ComponentBuilderElectricity.NEW_METER_CHECK_POS_Y,
                ComponentBuilderElectricity.NEW_METER_CHECK_WIDTH,
                ComponentBuilderElectricity.NEW_METER_CHECK_HEIGHT);

        newMeterReaderLabel.createLabels(
                ComponentBuilderElectricity.NEW_METER_LABEL_POS_X,
                ComponentBuilderElectricity.NEW_METER_LABEL_POS_Y,
                ComponentBuilderElectricity.NEW_METER_LABEL_WIDTH,
                ComponentBuilderElectricity.NEW_METER_LABEL_HEIGHT,
                ComponentBuilderElectricity.NEW_METER_LABEL_DISTANCE,
                ComponentBuilderElectricity.NEW_METER_LABEL_POSITION,
                newMeterReaderLabelNames);

        addComponentsToWindow(saveCancelButton.getButtons());
        addComponentsToWindow(cubicField.getFields());
        addComponentsToWindow(cubicFieldLabel.getLabels());
        addComponentsToWindow(newMeterReaderCheck.getCCheckBox());
        addComponentsToWindow(newMeterReaderLabel.getLabels());

        setVisible(true);
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

    public int getFieldCount(){
        return TEXT_FIELD_COUNT;
    }
}