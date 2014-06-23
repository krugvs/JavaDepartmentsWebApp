package com.krugvs.servlets.departments;

import com.krugvs.db.DBConnectionManager;
import com.krugvs.db.DepartmentTable;
import com.krugvs.entity.Department;

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
 * Created by vlad on 6/22/14.
 */
@WebServlet(name = "DepartmentList", urlPatterns = { "/departments" })
public class DepartmentList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
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
        getServletContext().getRequestDispatcher("/departments/list.jsp").forward(req, resp);
    }
}
