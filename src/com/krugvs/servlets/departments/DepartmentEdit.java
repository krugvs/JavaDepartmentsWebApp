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


/**
 * Created by vlad on 6/22/14.
 */
@WebServlet(name = "DepartmentEdit", urlPatterns = { "/departments/edit/*" })
public class DepartmentEdit  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id").trim());
        if (id!=0) {
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            DepartmentTable departmentTable = new DepartmentTable(con);
            Department department;
            department = departmentTable.getDepartmentById(id);
            if (department.getId()!=null) {
                req.setAttribute("department", department);
                req.setAttribute("actionUrl", req.getContextPath() + "/departments/edit/?id="+id);
                getServletContext().getRequestDispatcher("/departments/add.jsp").forward(req, resp);
            }
            else{

            }

        }else{
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", req.getContextPath() + "/departments");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name").trim();
        Integer id = Integer.parseInt(req.getParameter("id").trim());

        if (!name.equals("") && id!=0) {
            Department department = new Department(name, id);
            req.setAttribute("department", department);
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            DepartmentTable dt = new DepartmentTable(con);
            try {
                dt.saveDepartment(department);
            } catch (SQLException e) {
                e.printStackTrace();
                //TODO handle this
            }
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", req.getContextPath() + "/departments");
        }

        req.setAttribute("actionUrl", req.getContextPath() + "/departments/edit/?id="+id);
        getServletContext().getRequestDispatcher("/departments/add.jsp").forward(req, resp);
    }
}

