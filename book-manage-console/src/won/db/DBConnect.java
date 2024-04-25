package won.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String DATABASE_NAME = "bookmanagesys";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "040120";
    private static final String URL = String.format("jdbc:mysql://localhost:3306/%s?useUnicode=true&characterEncoding=utf8&useSSL=false", DATABASE_NAME);
    private static Connection connection = null;

    public static Connection getConnect() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed to create database connection: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    }
}