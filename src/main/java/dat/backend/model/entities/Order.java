package dat.backend.model.entities;

import java.security.Timestamp;

public class Order {
    int idOrder;
    int idUser;
    private Timestamp created;
    String status;

    public Order(int idUser, Timestamp created, String status) {
        this.idUser = idUser;
        this.created = created;
        this.status = status;
    }
}
