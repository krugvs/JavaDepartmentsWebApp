package com.krugvs.servlets.positions;

import com.krugvs.db.DepartmentTable;
import com.krugvs.db.PositionTable;
import com.krugvs.entity.Department;
import com.krugvs.entity.Position;

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
 * Created by vlad on 6/23/14.
 */
@WebServlet(name = "PositionList", urlPatterns = { "/positions" })
public class PositionList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
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
        getServletContext().getRequestDispatcher("/positions/list.jsp").forward(req, resp);
    }
}
