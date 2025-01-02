package com.algaier.MeterReading;

import com.algaier.MeterReading.Controller.DBConnect;
import com.algaier.MeterReading.Layout.LanguageManager;
import com.algaier.MeterReading.View.Dashboard.Dashboard;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		DBConnect db = new DBConnect();

		LanguageManager manager = new LanguageManager();
		manager.setLanguage("GERMAN");
		new Dashboard();
		//.createDbConnection();
		//db.createDbInput();
		//db.closeDbConneciton();
	}
}