package dat.backend.model.persistence;

import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Topping;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static dat.backend.model.persistence.UserMapper.connectionPool;

public class ShoppingcartMapper {
    public static ShoppingCart createShoppingcart(User user, ShoppingCart cart) {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "insert into Shoppingcart (Username, Status) values (?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getUsername());
                ps.setString(2, "In progress.");
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                cart.setIdShoppingcart(rs.getInt(1));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cart.setUsername(user.getUsername());
        cart.setStatus("In progress.");
        return cart;
    }
}
