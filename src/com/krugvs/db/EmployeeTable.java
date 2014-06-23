package com.krugvs.db;

import com.krugvs.entity.Employee;
import com.krugvs.db.DBConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 6/23/14.
 */
public class EmployeeTable extends DbTable {
    /**
     * @param con
     */
    public EmployeeTable(Connection con) {
        super(con);
    }



}
