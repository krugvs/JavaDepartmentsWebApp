package com.krugvs.db;

import com.krugvs.entity.Department;
import com.krugvs.entity.Employee;
import com.krugvs.db.DBConnectionManager;
import com.krugvs.entity.Position;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 *
 * Class to manage db requests for Employee
 * Created by vlad on 6/23/14.
 * @author vlad
 */
public class EmployeeTable extends DbTable {
    /**
     * @param con
     */
    public EmployeeTable(Connection con) {
        super(con);
    }

    /**
     * Return all employees
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Employee> getEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<Employee>();
        Registry<Department> registryDepartment = new Registry<Department>();
        Registry<Position> registryPosition = new Registry<Position>();
        try (
                Statement st = con.createStatement()
        ) {
            ResultSet rs =
                    st.executeQuery("SELECT `employees`.*, `departments`.*,  `positions`.* FROM `employees`\n" +
                            "JOIN `departments` ON employees.department_id=departments.id \n" +
                            "JOIN `positions` ON employees.position_id=positions.id ");
            while (rs.next()) {

                Integer id = rs.getInt("employees.id");
                String name = rs.getString("employees.username");
                java.util.Date birthday = rs.getDate("employees.birthday");
                String passportNumber = rs.getString("employees.passport");
                BigDecimal salary = rs.getBigDecimal("employees.salary");
                Integer Position_id = rs.getInt("positions.id");
                String Position_name = rs.getString("positions.name");
                BigDecimal Position_minSalary = rs.getBigDecimal("positions.minSalary");
                BigDecimal Position_maxSalary = rs.getBigDecimal("positions.maxSalary");
                Integer Department_id = rs.getInt("departments.id");
                String Department_name = rs.getString("departments.name");

                Department department = new Department(Department_name, Department_id);
                Position position = new Position(Position_id, Position_name, Position_minSalary, Position_maxSalary);
                department = registryDepartment.getById(Department_id, department);
                position = registryPosition.getById(Position_id, position);

                Employee employee = new Employee(id, name, birthday, passportNumber, salary, department, position);
                employees.add(employee);
                System.out.println(rs);
                System.out.println(rs.getInt("employees.id"));
                System.out.println(rs.getString("departments.name"));

            }
        }
        return employees;
    }

    /**
     * Return one employee by id
     * @param id
     * @return
     */
    public Employee getEmployeeById(Integer id) {
        try {

            PreparedStatement st = con.prepareStatement("SELECT `employees`.*, `departments`.*,  `positions`.* FROM `employees` JOIN `departments` ON employees.department_id=departments.id  JOIN `positions` ON employees.position_id=positions.id where employees.id = ? ");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer employees_id = rs.getInt("employees.id");
                String name = rs.getString("employees.username");
                java.util.Date birthday = rs.getDate("employees.birthday");
                String passportNumber = rs.getString("employees.passport");
                BigDecimal salary = rs.getBigDecimal("employees.salary");
                Integer Position_id = rs.getInt("positions.id");
                String Position_name = rs.getString("positions.name");
                BigDecimal Position_minSalary = rs.getBigDecimal("positions.minSalary");
                BigDecimal Position_maxSalary = rs.getBigDecimal("positions.maxSalary");
                Integer Department_id = rs.getInt("departments.id");
                String Department_name = rs.getString("departments.name");

                Department department = new Department(Department_name, Department_id);
                Position position = new Position(Position_id, Position_name, Position_minSalary, Position_maxSalary);
                Employee employee = new Employee(employees_id, name, birthday, passportNumber, salary, department, position);
                System.out.println(employee);
                return employee;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Return  all employees for some department
     * @param department
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Employee> getEmployeesByDepartment(Department department) throws SQLException, ClassNotFoundException {
        return getEmployeesByDepartmentId(department.getId());
    }

    /**
     * Return  all employees for department bu department id
     * @param departmentId
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Employee> getEmployeesByDepartmentId(Integer departmentId) throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<Employee>();
        Registry<Department> registryDepartment = new Registry<Department>();
        Registry<Position> registryPosition = new Registry<Position>();
        try{

            PreparedStatement st = con.prepareStatement("SELECT `employees`.*, `departments`.*,  `positions`.* FROM `employees` JOIN `departments` ON employees.department_id=departments.id  JOIN `positions` ON employees.position_id=positions.id where employees.department_id = ? ");
            st.setInt(1, departmentId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("employees.id");
                String name = rs.getString("employees.username");
                java.util.Date birthday = rs.getDate("employees.birthday");
                String passportNumber = rs.getString("employees.passport");
                BigDecimal salary = rs.getBigDecimal("employees.salary");
                Integer Position_id = rs.getInt("positions.id");
                String Position_name = rs.getString("positions.name");
                BigDecimal Position_minSalary = rs.getBigDecimal("positions.minSalary");
                BigDecimal Position_maxSalary = rs.getBigDecimal("positions.maxSalary");
                Integer Department_id = rs.getInt("departments.id");
                String Department_name = rs.getString("departments.name");

                Department department = new Department(Department_name, Department_id);
                Position position = new Position(Position_id, Position_name, Position_minSalary, Position_maxSalary);
                department = registryDepartment.getById(Department_id, department);
                position = registryPosition.getById(Position_id, position);

                Employee employee = new Employee(id, name, birthday, passportNumber, salary, department, position);
                employees.add(employee);
                System.out.println(rs);
                System.out.println(rs.getInt("employees.id"));
                System.out.println(rs.getString("departments.name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return employees;
    }

    /**
     * Save employee
     * @param employee
     */
    public void saveEmployee(Employee employee) throws SQLException {
        if (employee.getId() == 0) {
            insert(employee);
        } else {
            update(employee);
        }
    }

    /**
     * insert new record into DB
     * @param employee
     */
    protected void insert(Employee employee) throws SQLException {
        PreparedStatement st = con.prepareStatement("INSERT INTO  `employees` (\n" +
                "`id` ,\n" +
                "`username` ,\n" +
                "`birthday` ,\n" +
                "`passport` ,\n" +
                "`salary` ,\n" +
                "`department_id` ,\n" +
                "`position_id`\n" +
                ")\n" +
                "VALUES (\n" +
                "NULL ,  ?,  ?,  ?,  ?,  ?,  ?\n" +
                ");\n");
        st.setString(1, employee.getName());
        st.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
        st.setString(3, employee.getPassportNumber());
        st.setBigDecimal(4, employee.getSalary());
        st.setInt(5, employee.getDepartment().getId());
        st.setInt(6, employee.getPosition().getId());
        st.execute();
    }

    /**
     * Update existing record in DB
     * @param employee
     */
    protected void update(Employee employee) throws SQLException {
        PreparedStatement st = con.prepareStatement("UPDATE  `employees` SET  `username` =  ? ,\n" +
                "`birthday` =  ? ,\n" +
                "`passport` =  ? ,\n" +
                "`salary` =  ? ,\n" +
                "`department_id` =  ? ,\n" +
                "`position_id` =  ? WHERE  `employees`.`id` = ?;");
        st.setString(1, employee.getName());
        st.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
        st.setString(3, employee.getPassportNumber());
        st.setBigDecimal(4, employee.getSalary());
        st.setInt(5, employee.getDepartment().getId());
        st.setInt(6, employee.getPosition().getId());
        st.setInt(7, employee.getId());
        st.execute();
    }

    /**
     * Delete employee by id
     * @param id
     * @throws SQLException
     */
    public void deleteEmployeeById(Integer id) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM  `employees` WHERE  `employees`.`id` = ? ;");
        st.setInt(1, id);
        st.execute();
    }

    /**
     * Delete emplyee from DB
     * @param employee
     * @throws SQLException
     */
    public void deleteEmployee(Employee employee) throws SQLException {
        deleteEmployeeById(employee.getId());
    }

    /**
     * Inner class to handle duplicates of entities
     * @param <T>
     */
    protected class Registry<T> {
        private Map<Integer, T> items = new HashMap<>();

        /**
         * Save item into map if it is unique ID, else return previous stored entity
         * @param id
         * @param item
         * @return
         */
        public T getById(Integer id, T item) {
            if (!items.containsKey(id)) {
                items.put(id, item);
                return item;
            } else {
                return items.get(id);
            }
        }

        /**
         * Force add entity to map, replace existing entity
         * @param id
         * @param item
         * @return
         */
        public T add(Integer id, T item) {
            items.put(id, item);
            return item;
        }
    }

}
