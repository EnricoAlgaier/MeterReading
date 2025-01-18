package com.algaier.MeterReading.Controller;

import com.algaier.MeterReading.Controller.Services.CheckLogin;
import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Controller.Services.HashCoder;
import com.algaier.MeterReading.Layout.Components.CTextField;
import com.algaier.MeterReading.View.Dashboard.Dashboard;
import com.algaier.MeterReading.View.Login.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements ActionListener {
    private final Login login;
    private final CTextField passwordField;
    private final CTextField emailField;
    private final DBConnect dbConnect;
    private final ResourceBundle messages;

    public LoginController(Login login, CTextField passwordField, CTextField emailField, DBConnect dbConnect, ResourceBundle messages) {
        this.login = login;
        this.passwordField = passwordField;
        this.dbConnect = dbConnect;
        this.emailField = emailField;
        this.messages = messages;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonID = ((JButton) e.getSource()).getActionCommand();

        switch (buttonID) {
            case "login":
                HashCoder hashCoder = new HashCoder(passwordField);
                hashCoder.setPasswortTextInput(login.getFieldCount());

                try {
                    String passwordValue = hashCoder.hashEncoder();
                    CheckLogin checkLogin = new CheckLogin(emailField, dbConnect);
                    checkLogin.setEmailTextInput(login.getFieldCount());
                    boolean loginCheck = checkLogin.checkPasswordAndEmail(passwordValue);

                    if(loginCheck){
                        new Dashboard(messages, dbConnect);
                    } else{
                        JOptionPane.showMessageDialog(
                                null,
                                "E-Mail oder Passwort falsch",
                                "Fehler",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
                break;

            case "cancel":
                Login.closeWindow();
                break;

            case "register":
                break;
        }
    }
}