package org.example;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("application.properties")) {

            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return;
            }

            prop.load(input);

            String dbHost = prop.getProperty("database.host");
            String dbPort = prop.getProperty("database.port");
            String dbName = prop.getProperty("database.name");
            String dbUser = prop.getProperty("database.username");
            String dbPassword = prop.getProperty("database.password");

            String dbUrl = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;
            Properties dbProps = new Properties();
            dbProps.setProperty("user", dbUser);
            dbProps.setProperty("password", dbPassword);

            Connection conn = DriverManager.getConnection(dbUrl, dbProps);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Author";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            // file not found or database connection error
            System.out.println(e.getMessage());
        }

        System.out.println("Hello world!");
    }
}