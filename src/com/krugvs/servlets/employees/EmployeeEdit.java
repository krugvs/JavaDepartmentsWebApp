package com.krugvs.servlets.employees;

import com.krugvs.db.DepartmentTable;
import com.krugvs.db.EmployeeTable;
import com.krugvs.db.PositionTable;
import com.krugvs.entity.Department;
import com.krugvs.entity.Employee;
import com.krugvs.entity.Position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by vlad on 6/24/14.
 */
@WebServlet(name = "EmployeeEdit", urlPatterns = { "/employees/edit/*" })
public class EmployeeEdit  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id").trim());
        Connection con = (Connection) getServletContext().getAttribute("DBConnection");

        //delete action handle
        if (req.getParameter("action")!=null && req.getParameter("action").equals("delete")){

            EmployeeTable employeeTable = new EmployeeTable(con);
            try {
                employeeTable.deleteEmployeeById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", req.getContextPath() + "/employees");
        }

        DepartmentTable dt = new DepartmentTable(con);
        java.util.List<Department> listDepartments = new ArrayList<Department>();
        try {
            listDepartments = dt.getDepartments();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("listDepartments", listDepartments);

        PositionTable positionTablet = new PositionTable(con);
        java.util.List<Position> listPositions = new ArrayList<Position>();
        try {
            listPositions = positionTablet.getPositions();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("listPositions", listPositions);

        if (id!=0) {
            EmployeeTable employeeTable = new EmployeeTable(con);
            Employee employee;
            employee = employeeTable.getEmployeeById(id);
            if (employee!=null) {
                req.setAttribute("employee", employee);
                req.setAttribute("employeeId", id);
            }
        }else{
            req.setAttribute("employee", null);
            req.setAttribute("employeeId", null);
        }
        req.setAttribute("actionUrl", req.getContextPath() + "/employees/edit/?id="+id);
        getServletContext().getRequestDispatcher("/employees/add.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name").trim();
        String passportNumber = req.getParameter("passportNumber").trim();
        Integer id = Integer.parseInt(req.getParameter("id").trim());
        Integer position_id = Integer.parseInt(req.getParameter("position_id").trim());
        Integer department_id = Integer.parseInt(req.getParameter("department_id").trim());
        BigDecimal salary = new BigDecimal(req.getParameter("salary").trim());
        String birthDayStr = req.getParameter("birthday").trim();

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        Date birthday = new Date() ;

        try {
            birthday = ft.parse(birthDayStr);
            System.out.println(birthday);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }

        if (!name.equals("")) {
            Employee employee = new Employee(id,name, birthday, passportNumber, salary, new Department("", department_id), new Position(position_id, ""));
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            EmployeeTable dt = new EmployeeTable(con);
            try {
                dt.saveEmployee(employee);
            } catch (SQLException e) {
                e.printStackTrace();
                //TODO handle this
            }

            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", req.getContextPath() + "/employees");
        }
        req.setAttribute("employeeName", name);
        req.setAttribute("employeeName", id);
        req.setAttribute("actionUrl", req.getContextPath() + "/employees/edit/?id="+id);
        getServletContext().getRequestDispatcher("/employees/add.jsp").forward(req, resp);
    }

}

