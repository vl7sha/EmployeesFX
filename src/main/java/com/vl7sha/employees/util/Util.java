package com.vl7sha.employees.util;//подключение к бд

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_DRIVER = "";
    private static final String DB_URL = "";
    private static final String DB_USERNAME = "";
    private static final String DB_PASSWORD = "";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }
}
