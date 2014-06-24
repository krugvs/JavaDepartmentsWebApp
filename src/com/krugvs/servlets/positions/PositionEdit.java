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

/**
 * Created by vlad on 6/24/14.
 */
@WebServlet(name = "PositionEdit", urlPatterns = { "/positions/edit/*" })
public class PositionEdit  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
        Integer id = Integer.parseInt(req.getParameter("id").trim());
        if (id!=0) {
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            PositionTable positionTable = new PositionTable(con);
            Position position;
            position = positionTable.getPositionById(id);
            if (position.getId()!=null) {
                req.setAttribute("positionName", position.getName());
                req.setAttribute("positionId", position.getId());
                req.setAttribute("actionUrl", req.getContextPath() + "/positions/edit/?id="+id);
                req.setAttribute("minSalary", position.getMinSalary());
                req.setAttribute("maxSalary", position.getMaxSalary());
                getServletContext().getRequestDispatcher("/positions/add.jsp").forward(req, resp);
            }
            else{

            }

        }else{
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", req.getContextPath() + "/positions");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name").trim();
        Integer id = Integer.parseInt(req.getParameter("id").trim());
        BigDecimal minSalary = new BigDecimal(req.getParameter("minSalary").trim());
        BigDecimal maxSalary = new BigDecimal(req.getParameter("maxSalary").trim());

        if (!name.equals("") && id!=0) {
            Position position = new Position(id, name, minSalary, maxSalary);
            Connection con = (Connection) getServletContext().getAttribute("DBConnection");
            PositionTable dt = new PositionTable(con);
            try {
                dt.savePosition(position);
            } catch (SQLException e) {
                e.printStackTrace();
                //TODO handle this
            }
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location", req.getContextPath() + "/positions");
        }
        req.setAttribute("positionName", name);
        req.setAttribute("positionName", id);
        req.setAttribute("minSalary", minSalary);
        req.setAttribute("maxSalary", maxSalary);
        req.setAttribute("actionUrl", req.getContextPath() + "/positions/edit/?id="+id);
        getServletContext().getRequestDispatcher("/positions/add.jsp").forward(req, resp);
    }
}

