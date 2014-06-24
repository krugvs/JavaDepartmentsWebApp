package com.krugvs.db;

import com.krugvs.entity.Department;
import com.krugvs.entity.Employee;
import com.krugvs.db.DBConnectionManager;
import com.krugvs.entity.Position;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

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

    public Employee getEmployeeById(Integer id) {
        try {

            PreparedStatement st = con.prepareStatement("SELECT `employees`.*, `departments`.*,  `positions`.* FROM `employees` JOIN `departments` ON employees.department_id=departments.id  JOIN `positions` ON employees.position_id=positions.id where employees.id =? ");
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

    protected class Registry<T> {
        private Map<Integer, T> items = new HashMap<>();

        public T getById(Integer id, T item) {
            if (!items.containsKey(id)) {
                items.put(id, item);
                return item;
            } else {
                return items.get(id);
            }
        }

        public T add(Integer id, T item) {
            items.put(id, item);
            return item;
        }
    }

}
