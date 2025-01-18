package com.algaier.MeterReading.View.Login;

import com.algaier.MeterReading.Controller.LoginController;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.Components.CButton;
import com.algaier.MeterReading.Layout.Components.CLabel;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Layout.Window;
import com.algaier.MeterReading.Utils.ComponentBuilderLogin;

import javax.swing.*;
import java.util.ResourceBundle;

public class Login extends Window {
    private static final int WINDOW_POS_X = 500;
    private static final int WINDOW_POS_Y = 500;

    private static DBConnect dbConnection;
    private final int fieldCount = 1;

    public Login(ResourceBundle messages, DBConnect dbConnection) {
        super(WINDOW_POS_X, WINDOW_POS_Y);
        Login.dbConnection = dbConnection;

        int buttonCount = 2;
        int registerButtonCount = 1;
        int labelCount = 2;

        CTextField loginField = new CTextField(fieldCount);
        CTextField passwordField = new CTextField(fieldCount);
        CLabel loginLabel = new CLabel(labelCount);
        LoginController loginController = new LoginController(this, passwordField, loginField, dbConnection, messages);
        CButton menuButton = new CButton(loginController, buttonCount);
        CButton registerButton = new CButton(loginController, registerButtonCount);

        String[] buttonNames = {
                messages.getString("login"),
                messages.getString("cancel")};

        String[] registerButtonNames = {
                messages.getString("register")
        };

        String[] labeNames = {
                messages.getString("email"),
                messages.getString("password")
        };

        menuButton.createButtons(
                ComponentBuilderLogin.BUTTON_POS_X,
                ComponentBuilderLogin.BUTTON_POS_Y,
                ComponentBuilderLogin.BUTTON_WIDTH,
                ComponentBuilderLogin.BUTTON_HEIGHT,
                ComponentBuilderLogin.BUTTON_DISTANCE,
                buttonNames,
                ComponentBuilderLogin.SAVE_CANCEL_BUTTON_IDS,
                ComponentBuilderLogin.BUTTON_POSITION,
                loginController);

        registerButton.createButtons(
                ComponentBuilderLogin.REGISTER_BUTTON_POS_X,
                ComponentBuilderLogin.REGISTER_BUTTON_POS_Y,
                ComponentBuilderLogin.REGISTER_BUTTON_WIDTH,
                ComponentBuilderLogin.REGISTER_BUTTON_HEIGHT,
                ComponentBuilderLogin.REGISTER_BUTTON_DISTANCE,
                registerButtonNames,
                ComponentBuilderLogin.REGISTER_BUTTON_IDS,
                ComponentBuilderLogin.REGISTER_BUTTON_POSITION,
                loginController
        );

        loginField.createTextFields(
                ComponentBuilderLogin.LOGIN_FIELD_POS_X,
                ComponentBuilderLogin.LOGIN_FIELD_POS_Y,
                ComponentBuilderLogin.LOGIN_FIELD_WIDTH,
                ComponentBuilderLogin.LOGIN_FIELD_HEIGHT,
                ComponentBuilderLogin.LOGIN_FIELD_DISTANCE,
                ComponentBuilderLogin.LOGIN_FIELD_POSITION);

        passwordField.createPasswordFields(
                ComponentBuilderLogin.PASSWORD_FIELD_POS_X,
                ComponentBuilderLogin.PASSWORD_FIELD_POS_Y,
                ComponentBuilderLogin.PASSWORD_FIELD_WIDTH,
                ComponentBuilderLogin.PASSWORD_FIELD_HEIGHT,
                ComponentBuilderLogin.PASSWORD_FIELD_DISTANCE,
                ComponentBuilderLogin.PASSWORD_FIELD_POSITION);

        loginLabel.createLabels(
                ComponentBuilderLogin.LABEL_POS_X,
                ComponentBuilderLogin.LABEL_POS_Y,
                ComponentBuilderLogin.LABEL_WIDTH,
                ComponentBuilderLogin.LABEL_HEIGHT,
                ComponentBuilderLogin.LABEL_DISTANCE,
                ComponentBuilderLogin.LABEL_POSITION,
                labeNames);

        addComponentsToWindow(menuButton.getButtons());
        addComponentsToWindow(registerButton.getButtons());
        addComponentsToWindow(loginField.getFields());
        addComponentsToWindow(passwordField.getPasswords());
        addComponentsToWindow(loginLabel.getLabels());

        setDbConnection(dbConnection);
        close();
        setVisible(true);
    }

    public static void closeWindow() {
        Window.closeWindow(dbConnection);
    }

    public int getFieldCount(){
        return fieldCount;
    }

    private void addComponentsToWindow(JComponent... components) {
        for (JComponent component : components) {
            add(component);
        }
    }
}