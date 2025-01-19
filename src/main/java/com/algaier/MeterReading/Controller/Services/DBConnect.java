package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Model.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {
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

    public void saveGasTable(double cubic, LocalDateTime dateTime, String userEmail) {
        Gas gas = new Gas(cubic, "gas", dateTime, userEmail);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(gas);
        session.getTransaction().commit();
        session.close();
    }

    // TODO Session Facotry in function auslagern
    public void saveWaterTable(double cubic, String place, LocalDateTime dateTime, String waterType, String userEmail) {
        if (waterType.equals("cold")) {
            WaterCold waterCold = new WaterCold(cubic, place, "waterCold", dateTime, userEmail);

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(waterCold);
            session.getTransaction().commit();
            session.close();
        } else {
            WaterHot waterHot = new WaterHot(cubic, place, "waterHot", dateTime, userEmail);

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(waterHot);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void saveElectricityTable(double cubic, LocalDateTime dateTime, String userEmail) {
        Electricity electricity = new Electricity(cubic, "electricity", dateTime, userEmail);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(electricity);
        session.getTransaction().commit();
        session.close();
    }

    public void savePriceTable(BigDecimal productPrice, String product, BigDecimal basicCosts, BigDecimal abatement, String userEmail) {
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

    public void readValues(String email, String productName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Price> criteria = builder.createQuery(Price.class);
        Root<Price> root = criteria.from(Price.class);

        criteria.select(root)
                .where(builder.equal(root.get("userEmail"), email));

        Price result = session.createQuery(criteria).uniqueResult();

        if (result.getUserEmail() == null && (result.getProduct().equals(productName))) {


        }

    }
}