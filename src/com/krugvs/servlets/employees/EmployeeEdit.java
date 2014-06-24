package com.krugvs.servlets.employees;

import com.krugvs.db.EmployeeTable;
import com.krugvs.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vlad on 6/24/14.
 */
@WebServlet(name = "EmployeeEdit", urlPatterns = { "/employees/edit/*" })
public class EmployeeEdit  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id").trim());
        if (id!=0) {
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            EmployeeTable employeeTable = new EmployeeTable(con);
            Employee employee;
            employee = employeeTable.getEmployeeById(id);
            if (employee!=null) {
                req.setAttribute("employee", employee);
                req.setAttribute("employeeId", id);
                req.setAttribute("actionUrl", req.getContextPath() + "/employees/edit/?id="+id);
                getServletContext().getRequestDispatcher("/employees/add.jsp").forward(req, resp);
            }
            else{

            }

        }else{
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", req.getContextPath() + "/employees");
        }

    }
/*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name").trim();
        Integer id = Integer.parseInt(req.getParameter("id").trim());

        if (!name.equals("") && id!=0) {
            Employee employee = new Employee(name, id);
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            EmployeeTable dt = new EmployeeTable(con);

            try {
                //dt.saveEmployee(employee);
                dt=dt;
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
    */
}

