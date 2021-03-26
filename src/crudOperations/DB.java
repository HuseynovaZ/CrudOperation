package crudOperations;/*package crudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static void main(String[] args) {
        String userName = "root";
        String password = "mysql123";
        String url = "jdbc:mysql://localhost:3306/library";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace(System.err);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("The connections can not be closed.");
            }
        }

    }
}*/