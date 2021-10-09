/*
 * Copyright (c) 2021 Ideas2IT Technologies. All rights reserved.
 */
package com.ideas2it.employeemanagement.connection_utils;

import java.sql.DriverManager;
import java.sql.Connection;

/** 
 * This class contains utility method for establish connection to database.
 */
public class DatabaseConnection {
    private static Connection databaseConnection = null;
    
    /** 
     * Establishes connection to the database and returns the 
     * connection object. It establishes only single connection per thread.
     *
     * @return a database connection.
     */
    public static Connection getConnection() {
         if (databaseConnection == null) {
             try {
                 databaseConnection = DriverManager.getConnection("jdbc:mysql:"
                         + "//localhost:3306/employee_management", "root", 
                         "9159");
             } catch (Exception exception) {
                 exception.printStackTrace();
             }
         }
         return databaseConnection;
    }
}
