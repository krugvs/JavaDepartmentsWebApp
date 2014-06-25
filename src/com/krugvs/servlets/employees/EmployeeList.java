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
import java.util.ArrayList;

/**
 * Created by vlad on 6/24/14.
 */
@WebServlet(name = "EmployeeList", urlPatterns = { "/employees" })
public class EmployeeList extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //delete action handle
        Integer depid = 0;
        if (req.getParameter("depid")!=null && req.getParameter("depid").trim().toString()!=""){
            depid = Integer.parseInt(req.getParameter("depid").trim());
        }
        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
        EmployeeTable employeeTable = new EmployeeTable(con);
        java.util.List<Employee> listEmployees = new ArrayList<Employee>();
        try {
            if (depid>0){
                listEmployees = employeeTable.getEmployeesByDepartmentId(depid);
            }else{
                listEmployees = employeeTable.getEmployees();
            }
            System.out.println(listEmployees);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("listEmployees", listEmployees);
        getServletContext().getRequestDispatcher("/employees/list.jsp").forward(req, resp);

    }
}
