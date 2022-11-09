package dat.backend.model.persistence;

import dat.backend.model.entities.Topping;

import java.util.List;

public class ToppingFacade {
    public static List<Topping> getTopping (ConnectionPool connectionPool){
        return ToppingMapper.getTopping(connectionPool);
    }

    public static void toggleToping(String toppingVar, ConnectionPool connectionPool) {
        ToppingMapper.toggleTopping(toppingVar, connectionPool);
    }
}
