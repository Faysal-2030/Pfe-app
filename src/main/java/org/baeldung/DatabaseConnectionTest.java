package org.baeldung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectionTest {
    
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Database connection parameters
            String url = "jdbc:mysql://localhost:3307/hebergementdb?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "";
            
            System.out.println("Attempting to connect to the database...");
            
            // Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);
            
            System.out.println("Connection successful!");
            
            // Test query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT 1");
            
            if (resultSet.next()) {
                System.out.println("Query executed successfully!");
            }
            
            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
            
            System.out.println("Connection closed.");
            
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
