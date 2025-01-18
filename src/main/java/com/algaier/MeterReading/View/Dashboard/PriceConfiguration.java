package com.algaier.MeterReading.View.Dashboard;

import com.algaier.MeterReading.Controller.DashboardController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Components.CLabel;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Layout.Window;
import com.algaier.MeterReading.Utils.ComponentBuilderDashboard;

import javax.swing.*;
import java.util.ResourceBundle;

public class PriceConfiguration extends Window {

    private static final int WINDOW_POS_X = 1500;
    private static final int WINDOW_POS_Y = 800;

    private static final int buttonCounter = 4;
    private static final int saveCancelButtonCount = 1;
    private static final int inputFieldsCount = 3;
    private static final int inputLabelCount = 3;

    private final CLabel inputFIeldLabel = new CLabel(inputLabelCount);
    private String[] labelPriceConfig;
    private boolean isSave = false;
    private String productName;
    private final DBConnect dbConnection;
    private DashboardController dashboardListener;

    public PriceConfiguration(ResourceBundle messages, DBConnect dbConnection) {
        super(WINDOW_POS_X, WINDOW_POS_Y);
        this.dbConnection = dbConnection;
        CTextField inputFields = new CTextField(inputFieldsCount);
        DashboardController dashboardListener = new DashboardController(this, messages, dbConnection, inputFields);
        CButton menuButton = new CButton(dashboardListener, buttonCounter);

        String[] menuButtonNames = {
                messages.getString("gas_cost"),
                messages.getString("water_cost"),
                messages.getString("electricity_cost"),
                messages.getString("back")};

        menuButton.createButtons(ComponentBuilderDashboard.BUTTON_POS_X,
                ComponentBuilderDashboard.BUTTON_POS_Y,
                ComponentBuilderDashboard.BUTTON_WIDTH,
                ComponentBuilderDashboard.BUTTON_HEIGHT,
                ComponentBuilderDashboard.BUTTON_DISTANCE,
                menuButtonNames,
                ComponentBuilderDashboard.BUTTON_PRICE_CONFIGURATION_ID,
                ComponentBuilderDashboard.BUTTON_POSITION,
                dashboardListener);

        addComponentsToWindow(menuButton.getButtons());

        setDbConnection(dbConnection);
        close();
        setVisible(true);
    }

    public void createLabels(ResourceBundle messages) {
        String[] inputLabelNames = {
                messages.getString(labelPriceConfig[0]),
                messages.getString(labelPriceConfig[1]),
                messages.getString("abatement")
        };

        inputFIeldLabel.createLabels(ComponentBuilderDashboard.LABEL_POS_X,
                ComponentBuilderDashboard.LABEL_POS_Y,
                ComponentBuilderDashboard.LABEL_WIDTH,
                ComponentBuilderDashboard.LABEL_HEIGHT,
                ComponentBuilderDashboard.LABEL_DISTANCE,
                ComponentBuilderDashboard.LABEL_POSITION, inputLabelNames
        );

        addComponentsToWindow(inputFIeldLabel.getLabels());
    }

    public void createFields(CTextField inputFields, ResourceBundle messages, String productName) {
        inputFields.createTextFields(ComponentBuilderDashboard.FIELD_POS_X,
                ComponentBuilderDashboard.FIELD_POS_Y,
                ComponentBuilderDashboard.FIELD_WIDTH,
                ComponentBuilderDashboard.FIELD_HEIGHT,
                ComponentBuilderDashboard.FIELD_DISTANCE,
                ComponentBuilderDashboard.FIELD_POSITION);

        addComponentsToWindow(inputFields.getFields());
        createSaveButton(inputFields, messages, productName);
    }

    private void createSaveButton(CTextField inputFields, ResourceBundle messages, String productName){
        this.productName = productName;
        DashboardController dashboardController = new DashboardController(this, messages, inputFields, dbConnection);
        CButton saveCancelButton = new CButton(dashboardController, saveCancelButtonCount);

        String[] saveCancelButtonNames = {
                messages.getString("save")
        };

        saveCancelButton.createButtons(ComponentBuilderDashboard.BUTTON_SAVE_POS_X,
                ComponentBuilderDashboard.BUTTON_SAVE_POS_Y,
                ComponentBuilderDashboard.BUTTON_SAVE_WIDTH,
                ComponentBuilderDashboard.BUTTON_SAVE_HEIGHT,
                ComponentBuilderDashboard.BUTTON_SAVE_DISTANCE,
                saveCancelButtonNames,
                ComponentBuilderDashboard.BUTTON_SAVE_PRICE_CONFIGURATION_ID,
                ComponentBuilderDashboard.BUTTON_SAVE_POSITION,
                dashboardListener);

        addComponentsToWindow(saveCancelButton.getButtons());

        System.out.println(productName);
    }

    public void removeComponentsToWindow() {
        for (JLabel label : inputFIeldLabel.getLabels()) {
            if (label != null) {
                remove(label);
            }
        }
    }

    private void addComponentsToWindow(JComponent... components) {
        for (JComponent component : components) {
            add(component);
        }
    }

    public void setLabelPriceConfig(String[] labelPriceConfig) {
        this.labelPriceConfig = labelPriceConfig;
    }

    public boolean getIsSave(){
        return isSave;
    }

    public void setIsSave(boolean isSave){
        this.isSave = isSave;
    }

    public String getProductName(){
        return productName;
    }

    public int getInputFieldsCount(){
        return inputFieldsCount;
    }
}