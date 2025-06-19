package com.pluralsight.config;

import java.io.InputStream;
import java.util.Properties;

public class DbConfig {
    private static final Properties properties = new Properties();

    static {
//        Connectivity to the database and this code is executed only once
        try(InputStream input = DbConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null){
                System.err.println("Sorry, Unable to find application.properties");
                System.out.println("Attempting to load from environment variable....");
                properties.setProperty("db.url", System.getenv("DB_URL"));
                properties.setProperty("db.username", System.getenv("DB_USERNAME"));
                properties.setProperty("db.password", System.getenv("DB_PASSWORD"));
            }else{
                properties.load(input);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getDbUrl(){
        return properties.getProperty("db.url");
    }
    public static String getDbUsername(){
        return properties.getProperty("db.username");
    }
    public static String getDbPassword(){
        return properties.getProperty("db.password");
    }
}
