package com.algaier.MeterReading.Layout;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    private Locale localeLanguage;
    private ResourceBundle messages;
    private ErrorLog errorLog;

    private BufferedWriter languageFileWriter;
    private BufferedReader languageReader;

    public LanguageManager() {
        readLanguage();
    }

    public void setLanguage(String language) {
        try {
            languageFileWriter = new BufferedWriter(new FileWriter("src/main/resources/setLanguage.txt"));
            languageFileWriter.write(language);
            languageFileWriter.flush();
            languageFileWriter.close();

        } catch (IOException e) {
            errorLog  = new ErrorLog();
            errorLog.setErrorLog(errorLog.stringConverter(e));
        }
    }

    private void readLanguage() {
        try {
            languageReader = new BufferedReader(new FileReader("src/main/resources/setLanguage.txt"));
            String output = languageReader.readLine();
            languageReader.close();

            if(output != null) {
                localeLanguage = Locale.forLanguageTag(output);
                messages = ResourceBundle.getBundle("messages", localeLanguage);

            } else {
                localeLanguage = Locale.ENGLISH;
                messages = ResourceBundle.getBundle("messages", localeLanguage);

                errorLog  = new ErrorLog();
                errorLog.setErrorLog("setLanguage.txt file is empty");
            }


        } catch (Exception e) {
            errorLog  = new ErrorLog();
            errorLog.setErrorLog(errorLog.stringConverter(e));
        }
    }

    public Locale getLocaleLanguage() {
        return localeLanguage;
    }

}
