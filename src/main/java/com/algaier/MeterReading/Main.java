package com.algaier.MeterReading;

import com.algaier.MeterReading.Controller.Services.DBConnect;
import com.algaier.MeterReading.Layout.LanguageManager;
import com.algaier.MeterReading.View.Dashboard.Dashboard;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
	// Manage Languages
	private static final LanguageManager languageManager = new LanguageManager();
	private static final Locale locale = languageManager.getLocaleLanguage();
	private static final ResourceBundle messages = ResourceBundle.getBundle("messages", locale);

	// Window default size
	private static final int WINDOW_POS_X = 500;
	private static final int WINDOW_POS_Y = 600;

	// TODO add logfile to all try-catch
	// TODO error Log visibilty for users in an extra menu in the head
	// TODO implements a LogInWindow for DB, Username and Password

	public static void main(String[] args) {
		DBConnect dbConnection = new DBConnect();
		dbConnection.createDbConnection();

		LanguageManager manager = new LanguageManager();
		manager.setLanguage("GERMAN");

		new Dashboard(messages, dbConnection);
	}
}