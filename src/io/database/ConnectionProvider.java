package io.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        final String driver = "com.mysql.cj.jdbc.Driver";
        final String dbPath = "jdbc:mysql://localhost:3306/carrental1?serverTimezone=UTC&useSSL=false";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(dbPath, "root", "admin");
        return connection;
    }
}
