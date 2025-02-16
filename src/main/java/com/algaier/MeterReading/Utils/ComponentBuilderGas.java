package com.algaier.MeterReading.Utils;

public final class ComponentBuilderGas {

    private ComponentBuilderGas() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // static constants field
    public static final int CUBIC_FIELD_POS_X = 50;
    public static final int CUBIC_FIELD_POS_Y = 50;
    public static final int CUBIC_FIELD_WIDTH = 120;
    public static final int CUBIC_FIELD_HEIGHT = 40;
    public static final int CUBIC_FIELD_DISTANCE = 0;
    public static final String CUBIC_FIELD_POSITION = "";

    // static constants label for posY
    public static final int CUBIC_FIELD_LABEL_POS_X = 50;
    public static final int CUBIC_FIELD_LABEL_POS_Y = 30;
    public static final int CUBIC_FIELD_LABEL_WIDTH = 100;
    public static final int CUBIC_FIELD_LABEL_HEIGHT = 40;
    public static final int CUBIC_FIELD_LABEL_DISTANCE = 70;
    public static final String CUBIC_FIELD_LABEL_POSITION = "posY";

    // static constants date field
    public static final int DATE_FIELD_POS_X = 50;
    public static final int DATE_FIELD_POS_Y = 120;
    public static final int DATE_FIELD_WIDTH = 120;
    public static final int DATE_FIELD_HEIGHT = 40;
    public static final int DATE_FIELD_DISTANCE = 0;
    public static final String DATE_FIELD_POSITION = "";

    // static constants button for posX
    public static final int SAVE_CANCEL_BUTTON_POS_X = 50;
    public static final int SAVE_CANCEL_BUTTON_POS_Y = 380;
    public static final int SAVE_CANCEL_BUTTON_WIDTH = 140;
    public static final int SAVE_CANCEL_BUTTON_HEIGHT = 40;
    public static final int SAVE_CANCEL_BUTTON_DISTANCE = 150;
    public static final String SAVE_CANCEL_BUTTON_POSITION = "posX";

    // buttonId's for Water View
    public static final String[] SAVE_CANCEL_BUTTON_IDS = {"save", "cancel"};
}