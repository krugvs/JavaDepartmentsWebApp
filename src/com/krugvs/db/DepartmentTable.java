package com.krugvs.db;

import com.krugvs.entity.Department;
import com.krugvs.db.DBConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage db requests for Department
 * Created by vlad on 6/18/14.
 * @author vlad
 */
public class DepartmentTable extends DbTable {
    /**
     * @param con
     */
    public DepartmentTable(Connection con) {
        super(con);
    }

    /**
     * Get all departments
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Department> getDepartments() throws SQLException, ClassNotFoundException {
        List<Department> departments = new ArrayList<Department>();
        try (
                Statement st = con.createStatement()
        ) {
            ResultSet rs =
                    st.executeQuery("select id, name from departments");
            while (rs.next()) {
                Department dep = new Department(rs.getString(2), rs.getInt(1));
                departments.add(dep);
                System.out.println(dep);
            }
        }
        return departments;
    }

    /**
     * Save department
     * @param department
     */
    public void saveDepartment(Department department) throws SQLException {
        if (department.getId() == null) {
            insert(department);
        } else {
            update(department);
        }
    }

    /**
     * insert new record into DB
     *
     * @param department
     *
     */
    protected void insert(Department department) throws SQLException {
        PreparedStatement st = con.prepareStatement("INSERT INTO departments (name) VALUES (?)");
        st.setString(1, department.getName());
        st.execute();
    }

    /**
     * Update existing record in DB
     * @param department
     */
    protected void update(Department department) throws SQLException {
        PreparedStatement st = con.prepareStatement("UPDATE `departments` SET  `name` =  ? WHERE  `departments`.`id` = ? ;");
        st.setString(1, department.getName());
        st.setInt(2, department.getId());
        st.execute();
    }

    /**
     * Return one department by id
     * @param id
     * @return
     */
    public Department getDepartmentById(Integer id) {
        try {

            PreparedStatement st = con.prepareStatement("select id, name from departments where id= ? ");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Department department = new Department(rs.getString(2), rs.getInt(1));
                System.out.println(department);
                return department;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
