package com.niit.jdp;

import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        DatabaseService databaseService = new DatabaseService();

        try {
            databaseService.connect();


            Connection connection = databaseService.getConnection();
        } catch (ClassNotFoundException | SQLException exception) {
            System.err.println("Could not connect to the database!");
            exception.printStackTrace();


        }
    }
}