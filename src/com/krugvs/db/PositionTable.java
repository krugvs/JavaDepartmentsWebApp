package com.krugvs.db;

import com.krugvs.entity.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 6/18/14.
 */
public class PositionTable extends DbTable {

    /**
     * @param con
     */
    public PositionTable(Connection con) {
        super(con);
    }

    /**
     * @return
     * @throws java.sql.SQLException
     * @throws ClassNotFoundException
     */
    public List<Position> getPositions() throws SQLException, ClassNotFoundException {
        List<Position> positions = new ArrayList<Position>();
        try (
                Statement st = con.createStatement()
        ) {
            ResultSet rs =
                    st.executeQuery("select id, name, minSalary, maxSalary from positions");
            while (rs.next()) {
                Position position = new Position(rs.getInt(1), rs.getString(2), rs.getBigDecimal(3), rs.getBigDecimal(4));
                positions.add(position);
                System.out.println(position);
            }
        }
        return positions;
    }

    /**
     * @param position
     */
    public void savePosition(Position position) throws SQLException {
        if (position.getId() == null) {
            insert(position);
        } else {
            update(position);
        }
    }

    /**
     * @param position
     */
    protected void insert(Position position) throws SQLException {
        PreparedStatement st = con.prepareStatement("INSERT INTO positions (name, minSalary, maxSalary) VALUES ((?),(?),(?))");
        st.setString(1, position.getName());
        st.setBigDecimal(2, position.getMinSalary());
        st.setBigDecimal(3, position.getMaxSalary());
        st.execute();
    }

    /**
     * @param position
     */
    protected void update(Position position) throws SQLException {
        PreparedStatement st = con.prepareStatement("UPDATE `positions` SET  `name` =  (?) , `minSalary` = (?), `maxSalary` = (?) WHERE  `id` = (?) ;");
        st.setString(1, position.getName());
        st.setBigDecimal(2, position.getMinSalary());
        st.setBigDecimal(3, position.getMaxSalary());
        st.setInt(4, position.getId());
        st.execute();
    }

    /**
     * @param id
     * @return
     */
    public Position getPositionById(Integer id) {
        try {

            PreparedStatement st = con.prepareStatement("select  id, name, minSalary, maxSalary  from positions where id=(?)");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Position position = new Position(rs.getInt("id"), rs.getString("name"), rs.getBigDecimal("minSalary"), rs.getBigDecimal("maxSalary"));
                System.out.println(position);
                return position;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
