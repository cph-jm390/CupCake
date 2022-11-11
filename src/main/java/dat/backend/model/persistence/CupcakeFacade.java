package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Topping;

import java.util.List;

public class CupcakeFacade {

    public static List<Bottom> getBottom (ConnectionPool connectionPool){
        return CupcakeMapper.getBottom(connectionPool);
    }

    public static void toggleBottom(int idBottom, String bottomVar, ConnectionPool connectionPool) {
        CupcakeMapper.toggleBottom(idBottom, bottomVar, connectionPool);
    }
    public static List<Topping> getTopping (ConnectionPool connectionPool){
        return CupcakeMapper.getTopping(connectionPool);
    }

    public static void toggleToping(int idTopping,String toppingVar, ConnectionPool connectionPool) {
        CupcakeMapper.toggleTopping(idTopping,toppingVar, connectionPool);
    }
}
