package com.algaier.MeterReading.Controller.Services;

import com.algaier.MeterReading.Model.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {
    protected SessionFactory sessionFactory;
    private List<BigDecimal> priceList;

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

    public void updatePriceTable(BigDecimal productPrice, String product, BigDecimal basicCosts, BigDecimal abatement, String userEmail) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaUpdate<Price> update = builder.createCriteriaUpdate(Price.class);
            Root<Price> root = update.from(Price.class);

            update.set("price", productPrice)
                    .set("basicCost", basicCosts)
                    .set("abatement", abatement)
                    .where(
                            builder.and(
                                    builder.equal(root.get("userEmail"), userEmail),
                                    builder.equal(root.get("product"), product)
                            )
                    );

            session.createQuery(update).executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public boolean readPriceValues(String email, String productName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Price> criteria = builder.createQuery(Price.class);
        Root<Price> root = criteria.from(Price.class);
        priceList = new ArrayList<>();

        criteria.select(root)
                .where(
                        builder.and(
                                builder.equal(root.get("userEmail"), email),
                                builder.equal(root.get("product"), productName)
                        )
                );

        Price result = session.createQuery(criteria).uniqueResult();

        if (result != null) {
            priceList.add(result.getPrice());
            priceList.add(result.getBasicCost());
            priceList.add(result.getAbatement());
        }
        return result != null;
    }

    public Price readPriceValue(String email, String productName) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Price> criteria = builder.createQuery(Price.class);
        Root<Price> root = criteria.from(Price.class);

        criteria.select(root)
                .where(
                        builder.and(
                                builder.equal(root.get("userEmail"), email),
                                builder.equal(root.get("product"), productName)
                        )
                );

        Price result = session.createQuery(criteria).uniqueResult();

        return result;
    }

    public List<String> readGasValues(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Gas> criteria = builder.createQuery(Gas.class);
        Root<Gas> root = criteria.from(Gas.class);

        criteria.select(root)
                .where(
                        builder.and(
                                builder.equal(root.get("userEmail"), email)
                        )
                );

        Gas result = session.createQuery(criteria).uniqueResult();


        assert result != null;
        return result.gasList();
    }

    public List<String> readWaterColdValues(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<WaterCold> criteria = builder.createQuery(WaterCold.class);
        Root<WaterCold> root = criteria.from(WaterCold.class);

        criteria.select(root)
                .where(
                        builder.and(
                                builder.equal(root.get("userEmail"), email)
                        )
                );

        WaterCold result = session.createQuery(criteria).uniqueResult();

        assert result != null;
        return result.waterColdList();
    }

    public List<String> readWaterHotValues(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<WaterHot> criteria = builder.createQuery(WaterHot.class);
        Root<WaterHot> root = criteria.from(WaterHot.class);

        criteria.select(root)
                .where(
                        builder.and(
                                builder.equal(root.get("userEmail"), email)
                        )
                );

        WaterHot result = session.createQuery(criteria).uniqueResult();

        assert result != null;
        return result.waterHotList();
    }


    public List<String> readElectricityValues(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Electricity> criteria = builder.createQuery(Electricity.class);
        Root<Electricity> root = criteria.from(Electricity.class);

        criteria.select(root)
                .where(
                        builder.and(
                                builder.equal(root.get("userEmail"), email)
                        )
                );

        Electricity result = session.createQuery(criteria).uniqueResult();

        assert result != null;
        return result.electricitylist();
    }

    public UserInformation getUserInformation(String email) {
        Session session = sessionFactory.openSession();
        UserInformation userInformation = session.get(UserInformation.class, email);
        session.close();
        return userInformation;
    }

    public List<BigDecimal> getPriceList() {
        return priceList;
    }
}