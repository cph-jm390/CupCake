package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CupcakeMapper {

    static List<Bottom> getBottom(ConnectionPool connectionPool) {

        List<Bottom> BottomList = new ArrayList<>();

        String sql = "select * from Bottom";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int botId = rs.getInt("idBottom");
                    String bottomVar = rs.getString("bottomVar");
                    int bottomPrice = rs.getInt("bottomPrice");

                    Bottom newBottom = new Bottom(botId, bottomVar, bottomPrice);
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

    static List<Topping> getTopping(ConnectionPool connectionPool) {

        List<Topping> ToppingList = new ArrayList<>();

        String sql = "select * from Topping";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int topId=rs.getInt("idTopping");
                    String toppingVar = rs.getString("ToppingVar");
                    int toppingPrice = rs.getInt("toppingPrice");

                    Topping newTopping = new Topping(topId,toppingVar, toppingPrice);
                    ToppingList.add(newTopping);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ToppingList;
    }

    public static void toggleTopping(String ToppingVar, ConnectionPool connectionPool) {

        String sql = "UPDATE Topping SET done = (1 - done) WHERE ToppingVar = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, ToppingVar);
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
