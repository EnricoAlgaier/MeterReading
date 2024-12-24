package com.algaier.MeterReading;


import com.algaier.MeterReading.Controller.DBConnect;
import org.hibernate.type.LocalDateTimeType;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		DBConnect db = new DBConnect();
		LocalDateTime today = LocalDateTime.now();

		System.out.println(today);
		db.createSf();
		db.create();
		db.cancelSf();
	}

}