package dat.backend.model.entities;

import java.sql.Timestamp;

public class Topping {
   String toppingVar;
   int toppingPrice;

    public Topping(String toppingVar, int toppingPrice) {

        this.toppingVar = toppingVar;
        this.toppingPrice = toppingPrice;
    }
}
