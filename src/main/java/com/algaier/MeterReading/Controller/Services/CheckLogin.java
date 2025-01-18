package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.Model.UserInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckLogin {
    private List<String> emails;
    private final CTextField emailField;
    private DBConnect dbConnect;
    private UserInformation userInformation;

    public CheckLogin(CTextField emailField, DBConnect dbConnect) {
        this.emailField = emailField;
        this.dbConnect = dbConnect;
    }

    public boolean checkPasswordAndEmail(String password) {
        String email = emails.get(0);

        UserInformation userInformation = dbConnect.getUserInformation(email);

        return userInformation != null && userInformation.getPassword().equals(password);
    }

    public void setEmailTextInput(int fieldCounter) {
        emailField.textInput(fieldCounter);
        emails = new ArrayList<>();
        emails = emailField.getText();
    }
}