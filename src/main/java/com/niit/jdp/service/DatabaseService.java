/*
 * Author Name: M Jaya Suriya
 * Date: 9/20/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public DatabaseService() {
        // the initial value of `null` represents that the database connection object is not created yet and
        // the database is NOT CONNECTED to the Java program.
        this.connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean connect() throws ClassNotFoundException, SQLException {
        // 1. load the jdbc driver into memory
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. create a connection object using the DriverManager class
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        return connection != null;
    }

    public void printConnectionStatus() {
        if (connection != null) {
            System.out.println("\u001B[32m Database is connected. \u001B[0m");
        } else {
            System.err.println("!!Database is NOT connected!!");
        }
    }
}
