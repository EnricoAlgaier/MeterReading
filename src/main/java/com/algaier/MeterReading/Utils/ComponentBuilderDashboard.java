package com.algaier.MeterReading.Utils;

import java.awt.event.ActionListener;

public final class ComponentBuilderDashboard {

    private ComponentBuilderDashboard() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // static constants field for posY
    public static final int FIELD_POS_X = 300;
    public static final int FIELD_POS_Y = 50;
    public static final int FIELD_WIDTH = 100;
    public static final int FIELD_HEIGHT = 30;
    public static final int FIELD_DISTANCE = 80;
    public static final String FIELD_POSITION = "posY";

    // static constants label
    public static final int LABEL_POS_X = 300;
    public static final int LABEL_POS_Y = 20;
    public static final int LABEL_WIDTH = 150;
    public static final int LABEL_HEIGHT = 30;
    public static final int LABEL_DISTANCE = 80;
    public static final String LABEL_POSITION = "posY";

    // static constants button for posY
    public static final int BUTTON_POS_X = 50;
    public static final int BUTTON_POS_Y = 20;
    public static final int BUTTON_WIDTH = 180;
    public static final int BUTTON_HEIGHT = 50;
    public static final int BUTTON_DISTANCE = 50;
    public static final String BUTTON_POSITION = "posY";

    // static constants cold hot water button for posY
    public static final int BUTTON_SWITCH_POS_X = 600;
    public static final int BUTTON_SWITCH_POS_Y = 20;
    public static final int BUTTON_SWITCH_WIDTH = 180;
    public static final int BUTTON_SWITCH_HEIGHT = 50;
    public static final int BUTTON_SWITCH_DISTANCE = 50;
    public static final String BUTTON_SWITCH_POSITION = "posY";

    // static constants save button for posX
    public static final int BUTTON_SAVE_POS_X = 250;
    public static final int BUTTON_SAVE_POS_Y = 350;
    public static final int BUTTON_SAVE_WIDTH = 180;
    public static final int BUTTON_SAVE_HEIGHT = 40;
    public static final int BUTTON_SAVE_DISTANCE = 50;
    public static final String BUTTON_SAVE_POSITION = "";

    // buttonId's for Dashboard View
    public static final String[] BUTTON_DASHBOARD_ID = {"electricity", "gas", "water", "setprice", "close"};

    // buttonId's for Dashboard View
    public static final String[] BUTTON_SWITCH_PRICE_DASHBOARD_ID = {"water_cold", "water_hot"};

    // buttonId's for PriceConfiguration View
    public static final String[] BUTTON_PRICE_CONFIGURATION_ID = {"configuration_gas", "configuration_water", "configuration_electricity", "back"};

    // buttonId's for PriceConfiguration Save Cancel button
    public static final String[] BUTTON_SAVE_PRICE_CONFIGURATION_ID = {"save"};
}