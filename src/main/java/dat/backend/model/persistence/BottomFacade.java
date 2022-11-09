package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;

import java.util.List;

public class BottomFacade {
    public static List<Bottom> getBottom (ConnectionPool connectionPool){
        return BottomMapper.getBottom(connectionPool);
    }

    public static void toggleBottom(String bottomVar, ConnectionPool connectionPool) {
        BottomMapper.toggleBottom(bottomVar, connectionPool);
    }
}
