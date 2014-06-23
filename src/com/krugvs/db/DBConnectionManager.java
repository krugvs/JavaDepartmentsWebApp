package com.krugvs.db;

/**
 * Created by vlad on 6/22/14.
 */

import java.sql.*;
import com.mysql.jdbc.Driver;

public class DBConnectionManager {

    private static Connection connection;
    private static DBConnectionManager instance = null;

    public DBConnectionManager(String dbURL, String user, String password) throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        connection = DriverManager.getConnection(dbURL, user, password);
        //PreparedStatement st = connection.prepareStatement("set names utf8");
        //st.execute();
    }

    public Connection getConnection(){
        return connection;
    }

}

