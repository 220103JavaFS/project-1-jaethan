package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName(("org.postgresql.Driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://javafs220103.ciaghenqdjig.us-east-1.rds.amazonaws.com:5432/project1";
        // jdbc:postgresql://endpoint:hostnumber/DBname
        String username = "postgres"; // It is possible and preferable to hide this information in environment variables
        String password = "password"; // Those are accessed by System.getenv("var-name");
        //String password = System.getenv("SQLPassword");

        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args){
        try{
            getConnection();
            System.out.println("Connection successful");
        }catch (SQLException e){
            System.out.println("Connectiong failed");
            e.printStackTrace();
        }
    }
}
