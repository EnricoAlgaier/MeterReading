package com.algaier.MeterReading.View.Gas;

import com.algaier.MeterReading.Controller.GasController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Components.CCheckBox;
import com.algaier.MeterReading.Layout.Components.CLabel;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Layout.Window;
import com.algaier.MeterReading.Utils.ComponentBuilderElectricity;
import com.algaier.MeterReading.Utils.ComponentBuilderGas;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Consumption extends Window {
    private final CTextField cubicField;
    private final CTextField dateField;

    private static final int POS_X = 500;
    private static final int POS_Y = 500;
    private final  int textFieldCount = 1;

    public Consumption(ResourceBundle messages, DBConnect dbConnection, String userEmail) {
        super(POS_X, POS_Y);

        int LABEL_COUNT = 2;
        int BUTTON_COUNT = 2;
        int newMeterReaderLabelCount = 1;

        cubicField = new CTextField(textFieldCount);
        dateField = new CTextField(textFieldCount);

        CLabel cubicFieldLabel = new CLabel(LABEL_COUNT);
        CCheckBox newMeterReaderCheck = new CCheckBox();
        GasController gasController = new GasController(messages, this, cubicField, dateField, dbConnection, userEmail, newMeterReaderCheck);
        CLabel newMeterReaderLabel = new CLabel(newMeterReaderLabelCount);
        CButton saveCancelButton = new CButton(gasController, BUTTON_COUNT);

        String[] cubicLabelNames = {
                messages.getString("cubic"),
                messages.getString("date")};

        String[] saveCancelButtonNames = {
                messages.getString("save"),
                messages.getString("cancel")};

        String[] newMeterReaderLabelNames = {
                messages.getString("newMeterReaderLabel")
        };

        cubicField.createTextFields(
                ComponentBuilderGas.CUBIC_FIELD_POS_X,
                ComponentBuilderGas.CUBIC_FIELD_POS_Y,
                ComponentBuilderGas.CUBIC_FIELD_WIDTH,
                ComponentBuilderGas.CUBIC_FIELD_HEIGHT,
                ComponentBuilderGas.CUBIC_FIELD_DISTANCE,
                ComponentBuilderGas.CUBIC_FIELD_POSITION);

        cubicFieldLabel.createLabels(
                ComponentBuilderGas.CUBIC_FIELD_LABEL_POS_X,
                ComponentBuilderGas.CUBIC_FIELD_LABEL_POS_Y,
                ComponentBuilderGas.CUBIC_FIELD_LABEL_WIDTH,
                ComponentBuilderGas.CUBIC_FIELD_LABEL_HEIGHT,
                ComponentBuilderGas.CUBIC_FIELD_LABEL_DISTANCE,
                ComponentBuilderGas.CUBIC_FIELD_LABEL_POSITION,
                 cubicLabelNames);

        addComponentsToWindow(cubicField.getFields());
        addComponentsToWindow(cubicFieldLabel.getLabels());

        dateField.createTextFields(
                ComponentBuilderGas.DATE_FIELD_POS_X,
                ComponentBuilderGas.DATE_FIELD_POS_Y,
                ComponentBuilderGas.DATE_FIELD_WIDTH,
                ComponentBuilderGas.DATE_FIELD_HEIGHT,
                ComponentBuilderGas.DATE_FIELD_DISTANCE,
                ComponentBuilderGas.DATE_FIELD_POSITION);

        for (JTextField field : dateField.getFields()) {
            add(field);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDateTime dateTime = LocalDateTime.now();
            String formattedDate = dateTime.format(formatter);
            field.setText(formattedDate);
        }

        saveCancelButton.createButtons(
                ComponentBuilderGas.SAVE_CANCEL_BUTTON_POS_X,
                ComponentBuilderGas.SAVE_CANCEL_BUTTON_POS_Y,
                ComponentBuilderGas.SAVE_CANCEL_BUTTON_WIDTH,
                ComponentBuilderGas.SAVE_CANCEL_BUTTON_HEIGHT,
                ComponentBuilderGas.SAVE_CANCEL_BUTTON_DISTANCE,
                saveCancelButtonNames,
                ComponentBuilderGas.SAVE_CANCEL_BUTTON_IDS,
                ComponentBuilderGas.SAVE_CANCEL_BUTTON_POSITION,
                gasController);

        addComponentsToWindow(saveCancelButton.getButtons());

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

        addComponentsToWindow(newMeterReaderCheck.getCCheckBox());
        addComponentsToWindow(newMeterReaderLabel.getLabels());

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

    public int getFieldCount(){
        return textFieldCount;
    }

    public CTextField getDateField(){
        return dateField;
    }
}