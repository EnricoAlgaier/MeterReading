package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Model.Gas;
import com.algaier.MeterReading.Model.Price;
import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DBConnect {
	private LocalDateTime today = LocalDateTime.now();

	protected SessionFactory sessionFactory;

	public void createDbConnection() {
		StandardServiceRegistry registry = null;

		try {
			// Load environment variables
			Dotenv dotenv = Dotenv.configure().load();
			String dbUser = dotenv.get("DB_USER");
			String dbPassword = dotenv.get("DB_PASSWORD");

			// Configure Hibernate
			registry = new StandardServiceRegistryBuilder()
					.configure()
					.applySetting("hibernate.connection.username", dbUser)
					.applySetting("hibernate.connection.password", dbPassword)
					.build();

			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			System.out.println("SessionFactory successfully created.");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error creating SessionFactory: " + e.getMessage());
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
	}
	
	public void closeDbConneciton() {
		sessionFactory.close();
		System.out.println("sf geschlossen");
	}

	public void saveGasTable(double cubic, LocalDateTime dateTime){
		Gas gas = new Gas(cubic, 1, dateTime);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(gas);
		session.getTransaction().commit();
		System.out.println("Gas hinzugefügt");
		session.close();
	}

	public void savePriceTable(BigDecimal productPrice, String product, BigDecimal basicCosts, BigDecimal abatement){
		System.out.println("1." + productPrice + " 2." + product + " 3." + basicCosts + " 4." + abatement);
		Price price = new Price(productPrice, product, basicCosts, abatement);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(price);
		session.getTransaction().commit();
		System.out.println("Price hinzugefügt");
		session.close();
	}
}