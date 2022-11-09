package dat.backend.model.persistence;

import dat.backend.model.entities.Topping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToppingMapper {

    static List<Topping> getTopping(ConnectionPool connectionPool) {

        List<Topping> ToppingList = new ArrayList<>();

        String sql = "select * from Topping";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String toppingVar = rs.getString("ToppingVar");
                    int toppingPrice = rs.getInt("toppingPrice");

                    Topping newTopping = new Topping(toppingVar, toppingPrice);
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
