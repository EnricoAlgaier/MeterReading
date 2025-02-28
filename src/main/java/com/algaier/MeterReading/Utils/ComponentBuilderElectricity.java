package com.algaier.MeterReading.Utils;

public final class ComponentBuilderElectricity {

    private ComponentBuilderElectricity() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // static constants consumption cubic field
    public static final int CUBIC_FIELD_POS_X = 50;
    public static final int CUBIC_FIELD_POS_Y = 50;
    public static final int CUBIC_FIELD_WIDTH = 120;
    public static final int CUBIC_FIELD_HEIGHT = 40;
    public static final int CUBIC_FIELD_DISTANCE = 0;
    public static final String CUBIC_FIELD_POSITION = "";

    // static constants consumption cubic field label for posY
    public static final int CUBIC_FIELD_LABEL_POS_X = 50;
    public static final int CUBIC_FIELD_LABEL_POS_Y = 30;
    public static final int CUBIC_FIELD_LABEL_WIDTH = 100;
    public static final int CUBIC_FIELD_LABEL_HEIGHT = 40;
    public static final int CUBIC_FIELD_LABEL_DISTANCE = 70;
    public static final String CUBIC_FIELD_LABEL_POSITION = "posY";

    // static constants consumption date field
    public static final int DATE_FIELD_POS_X = 50;
    public static final int DATE_FIELD_POS_Y = 120;
    public static final int DATE_FIELD_WIDTH = 120;
    public static final int DATE_FIELD_HEIGHT = 40;
    public static final int DATE_FIELD_DISTANCE = 0;
    public static final String DATE_FIELD_POSITION = "";

    // static constants consumption save cancel button for posX
    public static final int SAVE_CANCEL_BUTTON_POS_X = 50;
    public static final int SAVE_CANCEL_BUTTON_POS_Y = 380;
    public static final int SAVE_CANCEL_BUTTON_WIDTH = 140;
    public static final int SAVE_CANCEL_BUTTON_HEIGHT = 40;
    public static final int SAVE_CANCEL_BUTTON_DISTANCE = 150;
    public static final String SAVE_CANCEL_BUTTON_POSITION = "posX";

    // static constants consumption new meter reader checkbox
    public static final int NEW_METER_CHECK_POS_X = 50;
    public static final int NEW_METER_CHECK_POS_Y = 190;
    public static final int NEW_METER_CHECK_WIDTH = 140;
    public static final int NEW_METER_CHECK_HEIGHT = 40;

    // static constants consumption new meter reader label
    public static final int NEW_METER_LABEL_POS_X = 70;
    public static final int NEW_METER_LABEL_POS_Y = 190;
    public static final int NEW_METER_LABEL_WIDTH = 350;
    public static final int NEW_METER_LABEL_HEIGHT = 40;
    public static final int NEW_METER_LABEL_DISTANCE = 150;
    public static final String NEW_METER_LABEL_POSITION = "";

    // static constants electricityWindow menuButton for posY
    public static final int MENU_BUTTON_POS_X = 50;
    public static final int MENU_BUTTON_POS_Y = 50;
    public static final int MENU_BUTTON_POS_WIDTH = 180;
    public static final int MENU_BUTTON_POS_HEIGHT = 50;
    public static final int MENU_BUTTON_POS_DISTANCE = 50;
    public static final String MENU_BUTTON_POS_POSITION = "posY";

    // static constants electricityWindow overviewLabel for posY
    public static final int OVERVIEW_LABEL_POS_X = 350;
    public static final int OVERVIEW_LABEL_POS_Y = 50;
    public static final int OVERVIEW_LABEL_POS_WIDTH = 180;
    public static final int OVERVIEW_LABEL_POS_HEIGHT = 50;
    public static final int OVERVIEW_LABEL_POS_DISTANCE = 50;
    public static final String OVERVIEW_LABEL_POS_POSITION = "posY";

    // buttonId's for Consumption View
    public static final String[] SAVE_CANCEL_BUTTON_IDS = {"save", "cancel"};

    // buttonId's fpr electricityWindow
    public static final String[] MENU_BUTTON_IDS = {"consumption", "overview", "statistics", "back"};
}