package com.rachelbock;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Provides connection to the jive_challenge database.
 * Uses Hikari internally to handle creation of connections and pooling of them.
 */
public class ConnectionPool {

    private static final HikariDataSource dataSource;


    static {
        //Default database name to main database. If the database name is set up the environment variable, use
        //that instead.
        String databaseName = "jive_challenge";
        if (System.getenv("DATABASE_NAME") != null) {
            databaseName = System.getenv("DATABASE_NAME");
        }

        //Default username for MySQL database unless Environment variable is set.
        String username = "root";
        if (System.getenv("DB_USERNAME") != null) {
            username = System.getenv("DB_USERNAME");
        }

        //Default password for MySQL database unless Environment variable is set.
        String password = "root";
        if (System.getenv("DB_PASSWORD") != null) {
            password = System.getenv("DB_PASSWORD");
        }



        //Shouldn't be necessary after Java 6, but for some versions of Tomcat and Java, the driver manager
        //will not connect without this.
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Setting up config
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/" + databaseName);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource = new HikariDataSource(config);

    }

    /**
     * Gets Connection to database from the pool.
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
