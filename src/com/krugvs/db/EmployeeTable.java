package com.krugvs.db;

import com.krugvs.entity.Employee;
import com.krugvs.db.DBConnectionManager;
import com.krugvs.entity.Position;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        try (
                Statement st = con.createStatement()
        ) {
            ResultSet rs =
                    st.executeQuery("SELECT `employees`.*, `departments`.*,  `positions`.* FROM `employees`\n" +
                            "JOIN `departments` ON employees.department_id=departments.id \n" +
                            "JOIN `positions` ON employees.position_id=positions.id ");
            while (rs.next()) {
                //Employee employee = new Employee();
                //employees.add(employee);
                System.out.println(rs);
                System.out.println(rs.getInt("employees.id"));
                System.out.println(rs.getString("departments.name"));

            }
        }
        return employees;
    }

    protected class PositionRegistry{
        private Map<Integer, Position> positions = new HashMap<>();

        public Position getPosition(Integer id, String name, BigDecimal minSalary, BigDecimal maxSalary) {
            if (!positions.containsKey(id)){
                Position position = new Position(id, name, minSalary, maxSalary);
                positions.put(id, position);
                return position;
            } else {
                return positions.get(id);
            }
        }

        public Position getPosition(Position position) {
            if (!positions.containsKey(position.getId())){
                positions.put(position.getId(), position);
                return position;
            } else {
                return positions.get(position.getId());
            }
        }
    }

}
