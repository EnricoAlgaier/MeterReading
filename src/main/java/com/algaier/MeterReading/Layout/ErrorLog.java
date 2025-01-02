package com.algaier.MeterReading.Layout;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

public class ErrorLog {
    private BufferedWriter errorlogWriter;
    private LocalDateTime timeNow;

    public void setErrorLog(String error) {
        try {
            timeNow = LocalDateTime.now();
            errorlogWriter = new BufferedWriter(new FileWriter("src/main/resources/errorlog.txt", true));
            errorlogWriter.write("[" + timeNow + "]" + "\t" + error + "\n");
            errorlogWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String stringConverter(Exception e) {
        StringWriter errorText = new StringWriter();
        PrintWriter convertErrorText = new PrintWriter(errorText);

        e.printStackTrace(convertErrorText);
        String errorString = errorText.toString();

        return errorString;
    }
}
