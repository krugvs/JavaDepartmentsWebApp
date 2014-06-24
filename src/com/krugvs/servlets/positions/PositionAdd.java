package com.krugvs.servlets.positions;

import com.krugvs.db.PositionTable;
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
import java.util.ArrayList;

/**
 * Created by vlad on 6/22/14.
 */
@WebServlet(name = "PositionAdd", urlPatterns = { "/positions/add" })
public class PositionAdd  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("positionName", "");
        req.setAttribute("positionId", null);
        req.setAttribute("actionUrl", req.getContextPath() + "/positions/add");

        getServletContext().getRequestDispatcher("/positions/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name").trim();
        BigDecimal minSalary = new BigDecimal(req.getParameter("minSalary").trim());
        BigDecimal maxSalary = new BigDecimal(req.getParameter("maxSalary").trim());

        if (!name.equals("")) {
            Position position = new Position(null, name, minSalary, maxSalary);
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            PositionTable positionTable = new PositionTable(con);
            try {
                positionTable.savePosition(position);
            } catch (SQLException e) {
                e.printStackTrace();
                //TODO handle this
            }
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", req.getContextPath() + "/positions");
        }
        req.setAttribute("positionName", name);
        req.setAttribute("positionId", null);
        req.setAttribute("actionUrl", req.getContextPath() + "/positions/add");
        getServletContext().getRequestDispatcher("/positions/add.jsp").forward(req, resp);
    }
}


