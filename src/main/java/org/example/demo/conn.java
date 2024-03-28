package org.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {
    public Connection theCon = null; // Connection to database
    public Statement theStmt = null; // Statement object

    public conn() {
        try {
            dbAccess acs = new dbAccess(); // Initialize the dbAccess object
            acs.loadDriver(); // Load the JDBC driver
            theCon = DriverManager.getConnection(acs.urlOfDatabase(), acs.username(), acs.password());
            theStmt = theCon.createStatement();
            theCon.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}