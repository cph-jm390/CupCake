package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BottomMapper {

    static List<Bottom> getBottom(ConnectionPool connectionPool) {

        List<Bottom> BottomList = new ArrayList<>();

        String sql = "select * from Bottom";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String bottomVar = rs.getString("bottomVar");
                    int bottomPrice = rs.getInt("bottomPrice");

                    Bottom newBottom = new Bottom(bottomVar, bottomPrice);
                    BottomList.add(newBottom);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return BottomList;
    }

    public static void toggleBottom(String bottomVar, ConnectionPool connectionPool) {

        String sql = "UPDATE Bottom SET done = (1 - done) WHERE bottomVar = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, bottomVar);
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
