package com.krugvs.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vlad on 6/17/14.
 */
public class Servlet1New extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "Vlad";
        req.setAttribute("name", name);
        getServletContext().getRequestDispatcher("/test.jsp").forward(req, resp);

    }
}
