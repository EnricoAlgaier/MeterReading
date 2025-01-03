package com.algaier.MeterReading.Layout.Components;

import com.algaier.MeterReading.Layout.Design.PasswordFieldCustom;
import com.algaier.MeterReading.Layout.Design.TextFieldCustom;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentListener;


public class CTextField {
    private final String textColorCode = "#FFFFFF";
    private final int textSize = 20;
    private final Font textFont = new Font("Arial", Font.PLAIN, textSize);

    private final TextFieldCustom[] fields;
    private final PasswordFieldCustom[] passwords;
    private final int textFieldCount;
    private List<String> fieldValue;
    private List<String> passwordValue;
    private final Color textColor = Color.decode(textColorCode);

    public CTextField(int textFieldCount) {
        this.textFieldCount = textFieldCount;
        fields = new TextFieldCustom[textFieldCount];
        passwords = new PasswordFieldCustom[textFieldCount];
    }

    public void createTextFields(int posX, int posY, int width, int height, int distance, String position) {
        fieldValue = new ArrayList<>();
        for (int createTextField = 0; createTextField < textFieldCount; createTextField++) {
            fields[createTextField] = new TextFieldCustom();
            fields[createTextField].setBounds(posX, posY, width, height);
            fields[createTextField].setForeground(textColor);
            fields[createTextField].setFont(textFont);

            if (position.equals("posX")) {
                posX += distance;
            } else if (position.equals("posY")) {
                posY += distance;
            }
        }
    }

    public void createPasswordFields(int posX, int posY, int width, int height, int distance, String position) {
        passwordValue = new ArrayList<>();
        for (int createTextField = 0; createTextField < textFieldCount; createTextField++) {
            passwords[createTextField] = new PasswordFieldCustom();
            passwords[createTextField].setBounds(posX, posY, width, height);
            passwords[createTextField].setForeground(textColor);
            passwords[createTextField].setFont(textFont);

            if (position.equals("posX")) {
                posX += distance;
            } else if (position.equals("posY")) {
                posY += distance;
            }
        }
    }

    public void createTextFieldsWithDocumentListener(int posX, int posY, int width, int height, int distance, String position, DocumentListener listener) {
        fieldValue = new ArrayList<>();
        for (int createTextField = 0; createTextField < textFieldCount; createTextField++) {
            fields[createTextField] = new TextFieldCustom();
            fields[createTextField].setBounds(posX, posY, width, height);
            fields[createTextField].setForeground(textColor);
            fields[createTextField].setFont(textFont);
            fields[createTextField].getDocument().addDocumentListener(listener);

            if (position.equals("posX")) {
                posX += distance;
            } else if (position.equals("posY")) {
                posY += distance;
            }
        }
    }

    public void textInput(int number) {
        fieldValue.clear();
        for (int index = 0; index < number; index++) {
            fieldValue.add(fields[index].getText());
        }
    }

    public void passwordInput(int number) {
        passwordValue.clear();
        for (int index = 0; index < number; index++) {
            char[] passwordChars = passwords[index].getPassword();
            String passwordString = new String(passwordChars);
            passwordValue.add(passwordString);
        }
    }

    public TextFieldCustom[] getFields() {
        return fields;
    }

    public PasswordFieldCustom[] getPasswords() {
        return passwords;
    }

    public List<String> getText() {
        return fieldValue;
    }

    public List<String> getPassword() {
        return passwordValue;
    }

}
