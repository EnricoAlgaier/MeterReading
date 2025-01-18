package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Model.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {
	protected SessionFactory sessionFactory;
	public enum PriceId {
		ELECTRICITY_ID(4),
		WATERCOLD_ID(2),
		WATERHOT_ID(3),
		GAS_ID(1);

		private final int id;

		PriceId(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}
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
			System.out.println("DbConnection successfully created.");
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
		System.out.println("dbConnection closed");
	}

	public void saveGasTable(double cubic, LocalDateTime dateTime, String userEmail){
		Gas gas = new Gas(cubic, PriceId.GAS_ID.getId(), dateTime, userEmail);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(gas);
		session.getTransaction().commit();
		session.close();
	}
// TODO Session Facotry in function auslagern
	public void saveWaterTable(double cubic, String place, LocalDateTime dateTime, String waterType, String userEmail){
		if(waterType.equals("cold")){
			WaterCold waterCold = new WaterCold(cubic, place, PriceId.WATERCOLD_ID.getId(), dateTime, userEmail);

			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(waterCold);
			session.getTransaction().commit();
			session.close();
		} else{
			WaterHot waterHot = new WaterHot(cubic, place, PriceId.WATERHOT_ID.getId(), dateTime, userEmail);

			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(waterHot);
			session.getTransaction().commit();
			session.close();
		}
	}

	public void saveElectricityTable(double cubic, LocalDateTime dateTime, String userEmail){
		Electricity electricity = new Electricity(cubic, PriceId.ELECTRICITY_ID.getId(), dateTime, userEmail);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(electricity);
		session.getTransaction().commit();
		session.close();
	}

	public void savePriceTable(BigDecimal productPrice, String product, BigDecimal basicCosts, BigDecimal abatement, String userEmail){
		Price price = new Price(productPrice, product, basicCosts, abatement, userEmail);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(price);
		session.getTransaction().commit();
		session.close();
	}

	public UserInformation getUserInformation(String email) {
		Session session = sessionFactory.openSession();
		UserInformation userInformation = session.get(UserInformation.class, email);
		session.close();
		return userInformation;
	}
}