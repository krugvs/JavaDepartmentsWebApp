package com.krugvs.db;

import java.sql.Connection;

/**
 * Created by vlad on 6/23/14.
 */
abstract public class DbTable {


    /**
     *
     */
    protected Connection con = null;

    /**
     * @param con
     */
    public DbTable(Connection con) {
        this.con = con;
    }
}
