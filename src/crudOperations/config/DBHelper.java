package crudOperations.config;

import java.io.InputStream;
import java.sql.*;
import java.util.Locale;
import java.util.Properties;

public class DBHelper {
    static {
        Locale.setDefault(Locale.ENGLISH);
    }

    public static Connection connect() throws Exception {
        String path = "crudOperations/config/config.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, username, password);
        if (connection != null) {
            System.out.println("Connection is success!");
        }
        return connection;
    }

    public static void disconnect(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (resultSet!=null){
            resultSet.close();
        }
    }}
