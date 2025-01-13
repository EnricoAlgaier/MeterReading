package com.algaier.MeterReading.Utils;

public final class ComponentBuilderWater {

    private ComponentBuilderWater() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // static constants field for posY
    public static final int FIELD_POS_X = 50;
    public static final int FIELD_POS_Y = 50;
    public static final int FIELD_WIDTH = 120;
    public static final int FIELD_HEIGHT = 40;
    public static final int FIELD_DISTANCE = 70;
    public static final String FIELD_POSITION = "posY";

    // static constants label
    public static final int LABEL_POS_X = 50;
    public static final int LABEL_POS_Y = 30;
    public static final int LABEL_WIDTH = 100;
    public static final int LABEL_HEIGHT = 40;
    public static final int LABEL_DISTANCE = 70;
    public static final String LABEL_POSITION = "posY";

    // static constants date field
    public static final int DATE_FIELD_POS_X = 50;
    public static final int DATE_FIELD_POS_Y = 190;
    public static final int DATE_FIELD_WIDTH = 120;
    public static final int DATE_FIELD_HEIGHT = 40;
    public static final int DATE_FIELD_DISTANCE = 0;
    public static final String DATE_FIELD_POSITION = "";

    // static constants button for posY
    public static final int BUTTON_POS_X = 50;
    public static final int BUTTON_POS_Y = 20;
    public static final int BUTTON_WIDTH = 180;
    public static final int BUTTON_HEIGHT = 50;
    public static final int BUTTON_DISTANCE = 50;
    public static final String BUTTON_POSITION = "posY";

    // static constants save button for posX
    public static final int BUTTON_SAVE_POS_X = 50;
    public static final int BUTTON_SAVE_POS_Y = 380;
    public static final int BUTTON_SAVE_WIDTH = 140;
    public static final int BUTTON_SAVE_HEIGHT = 40;
    public static final int BUTTON_SAVE_DISTANCE = 150;
    public static final String BUTTON_SAVE_POSITION = "posX";

    // buttonId's for Water View
    public static final String[] SAVE_CANCEL_BUTTON_IDS = {"save", "cancel"};
}