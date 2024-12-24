package com.algaier.MeterReading.Controller;


import com.algaier.MeterReading.Model.Gas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DBConnect {
	private LocalDateTime today = LocalDateTime.now();

	protected SessionFactory sf;

	public void createSf() {
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure(DBConnect.class.getClassLoader().getResource("hibernate.cfg.xml"))
					.build();

			sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			System.out.println("Sf successfully created.");
		} catch (Exception e) {
			e.printStackTrace(); // Zeigt vollständige Fehlerdetails
			System.out.println("Fehler: " + e.getMessage());
		}
	}
	
	public void cancelSf() {
		sf.close();
		System.out.println("sf geschlossen");
	}

	public void create(){
		Gas gas = new Gas(10.55, 1, today);

		Session session = sf.openSession();
		session.beginTransaction();
		session.save(gas);
		session.getTransaction().commit();
		System.out.println("Gas hinzugefügt");
		session.close();

	}
}