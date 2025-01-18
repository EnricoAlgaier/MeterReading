package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Layout.Components.CTextField;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class HashCoder {
    private List<String> passwords;
    private final CTextField passwordField;

    public HashCoder(CTextField passwordField){
        this.passwordField = passwordField;
    }

    public String hashEncoder() throws NoSuchAlgorithmException {

        String hash = passwords.get(0);
        MessageDigest digest = MessageDigest.getInstance("SHA3-512");
        byte[] hashBytes = digest.digest(hash.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }

    public void setPasswortTextInput(int fieldCounter) {
        passwordField.passwordInput(fieldCounter);
        passwords = new ArrayList<>();
        passwords = passwordField.getPassword();
    }
}