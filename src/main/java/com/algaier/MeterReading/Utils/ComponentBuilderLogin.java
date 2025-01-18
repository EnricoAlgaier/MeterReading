package com.algaier.MeterReading.Utils;

public final class ComponentBuilderLogin {

    private ComponentBuilderLogin() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // static constants login field
    public static final int LOGIN_FIELD_POS_X = 50;
    public static final int LOGIN_FIELD_POS_Y = 200;
    public static final int LOGIN_FIELD_WIDTH = 120;
    public static final int LOGIN_FIELD_HEIGHT = 40;
    public static final int LOGIN_FIELD_DISTANCE = 0;
    public static final String LOGIN_FIELD_POSITION = "";

    // static constants password field
    public static final int PASSWORD_FIELD_POS_X = 180;
    public static final int PASSWORD_FIELD_POS_Y = 200;
    public static final int PASSWORD_FIELD_WIDTH = 120;
    public static final int PASSWORD_FIELD_HEIGHT = 40;
    public static final int PASSWORD_FIELD_DISTANCE = 0;
    public static final String PASSWORD_FIELD_POSITION = "";

    // static constants label
    public static final int LABEL_POS_X = 50;
    public static final int LABEL_POS_Y = 170;
    public static final int LABEL_WIDTH = 120;
    public static final int LABEL_HEIGHT = 40;
    public static final int LABEL_DISTANCE = 130;
    public static final String LABEL_POSITION = "posX";

    // static constants button for posY
    public static final int BUTTON_POS_X = 50;
    public static final int BUTTON_POS_Y = 300;
    public static final int BUTTON_WIDTH = 140;
    public static final int BUTTON_HEIGHT = 40;
    public static final int BUTTON_DISTANCE = 150;
    public static final String BUTTON_POSITION = "posX";

    // static constants register button
    public static final int REGISTER_BUTTON_POS_X = 300;
    public static final int REGISTER_BUTTON_POS_Y = 20;
    public static final int REGISTER_BUTTON_WIDTH = 150;
    public static final int REGISTER_BUTTON_HEIGHT = 30;
    public static final int REGISTER_BUTTON_DISTANCE = 0;
    public static final String REGISTER_BUTTON_POSITION = "";

    // buttonId's for Login View
    public static final String[] SAVE_CANCEL_BUTTON_IDS = {"login", "cancel"};

    // buttonId for register
    public static final String[] REGISTER_BUTTON_IDS = {"register"};
}