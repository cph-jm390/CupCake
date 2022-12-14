package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Topping;

import java.util.List;

public class CupcakeFacade {

    public static List<Bottom> getBottom(ConnectionPool connectionPool) {
        return CupcakeMapper.getBottom(connectionPool);
    }

    public static List<Topping> getTopping(ConnectionPool connectionPool) {
        return CupcakeMapper.getTopping(connectionPool);
    }

    public static void insertCupcakeToDB(ShoppingCart cart) {
        CupcakeMapper.insertCupcakeToDB(cart);
    }

    public static List<Cupcake> getCupcakes(ConnectionPool connectionPool) {
        return CupcakeMapper.getCupcakes(connectionPool);
    }

}

