package com.algaier.MeterReading.Utils;

public final class ComponentBuilderWater {

    private ComponentBuilderWater() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // static constants field for posY
    public static final int FIELD_POS_X = 250;
    public static final int FIELD_POS_Y = 50;
    public static final int FIELD_WIDTH = 120;
    public static final int FIELD_HEIGHT = 40;
    public static final int FIELD_DISTANCE = 0;
    public static final String FIELD_POSITION = "";

    // static constants label
    public static final int LABEL_POS_X = 250;
    public static final int LABEL_POS_Y = 30;
    public static final int LABEL_WIDTH = 100;
    public static final int LABEL_HEIGHT = 40;
    public static final int LABEL_DISTANCE = 70;
    public static final String LABEL_POSITION = "posY";

    // static constants date field
    public static final int DATE_FIELD_POS_X = 250;
    public static final int DATE_FIELD_POS_Y = 120;
    public static final int DATE_FIELD_WIDTH = 120;
    public static final int DATE_FIELD_HEIGHT = 40;
    public static final int DATE_FIELD_DISTANCE = 0;
    public static final String DATE_FIELD_POSITION = "";

    // static constants button for posY
    public static final int BUTTON_POS_X = 20;
    public static final int BUTTON_POS_Y = 20;
    public static final int BUTTON_WIDTH = 200;
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

    // static constants consumption new meter reader label
    public static final int NEW_METER_LABEL_POS_X = 270;
    public static final int NEW_METER_LABEL_POS_Y = 260;
    public static final int NEW_METER_LABEL_WIDTH = 350;
    public static final int NEW_METER_LABEL_HEIGHT = 40;
    public static final int NEW_METER_LABEL_DISTANCE = 150;
    public static final String NEW_METER_LABEL_POSITION = "";

    // static constants consumption new meter reader checkbox
    public static final int NEW_METER_CHECK_POS_X = 250;
    public static final int NEW_METER_CHECK_POS_Y = 260;
    public static final int NEW_METER_CHECK_WIDTH = 140;
    public static final int NEW_METER_CHECK_HEIGHT = 40;

    // static constants consumption meter reader location
    public static final int METER_READER_LOCATION_POS_X = 430;
    public static final int METER_READER_LOCATION_POS_Y = 70;
    public static final int METER_READER_LOCATION_WIDTH = 20;
    public static final int METER_READER_LOCATION_HEIGHT = 20;
    public static final int METER_READER_LOCATION_DISTANCE = 30;
    public static final String METER_READER_LOCATION_LABEL_POSITION = "posY";

    // static constants consumption meter reader location
    public static final int METER_READER_LABEL_LOCATION_POS_X = 460;
    public static final int METER_READER_LABEL_LOCATION_POS_Y = 70;
    public static final int METER_READER_LABEL_LOCATION_WIDTH = 100;
    public static final int METER_READER_LABEL_LOCATION_HEIGHT = 20;
    public static final int METER_READER_LABEL_LOCATION_DISTANCE = 30;
    public static final String METER_READER_LABEL_LOCATION_LABEL_POSITION = "posY";

    // static constants meter reader location label
    public static final int METER_READER_LOCATION_LABEL_POS_X = 430;
    public static final int METER_READER_LOCATION_LABEL_POS_Y = 30;
    public static final int METER_READER_LOCATION_LABEL_WIDTH = 100;
    public static final int METER_READER_LOCATION_LABEL_HEIGHT = 40;
    public static final int METER_READER_LOCATION_LABEL_DISTANCE = 0;
    public static final String METER_LOCATION_LABEL_POSITION = "";

    // buttonId's for Water View
    public static final String[] SAVE_CANCEL_BUTTON_IDS = {"save", "cancel"};
    public static final String[] BUTTON_IDS = {"cold", "hot"};
    public static final String[] LOCATION_BUTTON_IDS = {"kitchen", "bathroom", "laundryRoom", "garden", "basement", "centralMeter"};
}