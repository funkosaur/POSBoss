package org.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class derbyAccess {
    public static void main(String[] args) {
        // Load the Derby JDBC driver (optional for JDBC 4.0 and later)
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load Derby JDBC driver: " + e.getMessage());
            return;
        }

        // JDBC URL for connecting to the database
        String url = "jdbc:derby:POSBoss;create=true";

        try (Connection connection = DriverManager.getConnection(url)) {
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
