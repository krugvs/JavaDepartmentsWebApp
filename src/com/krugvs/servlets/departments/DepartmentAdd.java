package com.krugvs.servlets.departments;

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
@WebServlet(name = "DepartmentAdd", urlPatterns = { "/departments/add" })
public class DepartmentAdd  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departmentName", "");
        req.setAttribute("departmentId", null);
        req.setAttribute("actionUrl", req.getContextPath() + "/departments/add");

        getServletContext().getRequestDispatcher("/departments/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name").trim();

        if (!name.equals("")) {
            Department department = new Department(name);
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            DepartmentTable departmentTable = new DepartmentTable(con);
            try {
                departmentTable.saveDepartment(department);
            } catch (SQLException e) {
                e.printStackTrace();
                //TODO handle this
            }
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", req.getContextPath() + "/departments");
        }
        req.setAttribute("departmentName", name);
        req.setAttribute("departmentId", null);
        req.setAttribute("actionUrl", req.getContextPath() + "/departments/add");
        getServletContext().getRequestDispatcher("/departments/add.jsp").forward(req, resp);
    }
}


