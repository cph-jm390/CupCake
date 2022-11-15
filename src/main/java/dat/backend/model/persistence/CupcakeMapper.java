package dat.backend.model.persistence;

import dat.backend.control.AddToCart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CupcakeMapper {
    public static ConnectionPool connectionPool = new ConnectionPool();

    static List<Bottom> getBottom(ConnectionPool connectionPool) {
        List<Bottom> BottomList = new ArrayList<>();
        String sql = "select * from bottom";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idBottom = rs.getInt("idBottom");
                    String BottomVar = rs.getString("BottomVar");
                    int BottomPrice = rs.getInt("BottomPrice");

                    Bottom newBottom = new Bottom(idBottom, BottomVar, BottomPrice);
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

    /*
    public static void toggleBottom(int idBottom, String BottomVar, ConnectionPool connectionPool) {

        String sql = "UPDATE bottom SET done = (1 - done) WHERE BottomVar = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idBottom);
                ps.setString(2, BottomVar);
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
     */

    static List<Topping> getTopping(ConnectionPool connectionPool) {
        List<Topping> ToppingList = new ArrayList<>();
        String sql = "select * from topping";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int topId = rs.getInt("idTopping");
                    String toppingVar = rs.getString("ToppingVar");
                    int toppingPrice = rs.getInt("ToppingPrice");

                    Topping newTopping = new Topping(topId, toppingVar, toppingPrice);
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

    /*
    public static void toggleTopping(int idTopping, String ToppingVar, ConnectionPool connectionPool) {

        String sql = "UPDATE topping SET done = (1 - done) WHERE ToppingVar = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, idTopping);
                ps.setString(2, ToppingVar);
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

     */

    public static void insertCupcakeToDB(ShoppingCart cart) {
        String sql = "INSERT INTO Cupcake (idTopping, idBottom, Quantity, CupcakeTotalPrice, idShoppingcart) VALUES (?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                for (int i = 0; i < cart.getCupcakeList().size(); i++) {
                    ps.setInt(1, cart.getCupcakeList().get(i).getIdTopping());
                    ps.setInt(2, cart.getCupcakeList().get(i).getIdBottom());
                    ps.setInt(3, cart.getCupcakeList().get(i).getQuantity());
                    ps.setInt(4, cart.getCupcakeList().get(i).getCupcakeprice());
                    ps.setInt(5, cart.getIdShoppingcart());
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cart.getCupcakeList().clear();
    }
    public static int cupcakeCalc(ShoppingCart cart){
        int totalorderPrice=0;
        for(Cupcake cupcake: cart.getCupcakeList()){
            totalorderPrice+=cupcake.getCupcakeprice();
        }
    return totalorderPrice;

    }

    static List<Cupcake> getCupcakes(ConnectionPool connectionPool) {
        List<Cupcake> dbCupcakeList = new ArrayList<>();
        String sql = "select * from Cupcake";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                // idShoppingcart, idTopping, idBottom, Quantity, CupcakeTotalPrice
                
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idShoppingcard = rs.getInt("idShoppingcard");
                    int idTopping = rs.getInt("idTopping");
                    int idBottom = rs.getInt("idBottom");
                    int quantity = rs.getInt("Quantity");
                    int cupcakeTotalPrice = rs.getInt("CupcakeTotalPrice");


                    Cupcake newCupcake = new Cupcake(quantity,idTopping,idBottom,cupcakeTotalPrice,idShoppingcard);
                    dbCupcakeList.add(newCupcake);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dbCupcakeList;
    }

}