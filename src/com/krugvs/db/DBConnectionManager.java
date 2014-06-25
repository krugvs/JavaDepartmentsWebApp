package com.krugvs.db;

/**
 * Created by vlad on 6/22/14.
 */

import java.sql.*;
import com.mysql.jdbc.Driver;

/**
 * Manage DB connection
 * @author vlad
 */
public class DBConnectionManager {

    private static Connection connection;
    private static DBConnectionManager instance = null;

    /**
     * Creating new connection from url and credentials
     * @param dbURL
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public DBConnectionManager(String dbURL, String user, String password) throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public Connection getConnection(){
        return connection;
    }

}

