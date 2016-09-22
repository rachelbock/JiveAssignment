package com.rachelbock;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Provides connection to the jive_challenge database and method to get a connection as needed.
 */
public class ConnectionPool {

    private static final HikariDataSource dataSource;


    static {
        String databaseName = "jive_challenge";
        if (System.getenv("DATABASE_NAME") != null) {
            databaseName = System.getenv("DATABASE_NAME");
        }

        String username = "root";
        if (System.getenv("DB_USERNAME") != null) {
            username = System.getenv("DB_USERNAME");
        }

        String password = "root";
        if (System.getenv("DB_PASSWORD") != null) {
            password = System.getenv("DB_PASSWORD");
        }




        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/" + databaseName);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource = new HikariDataSource(config);

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
