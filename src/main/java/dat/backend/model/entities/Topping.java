package dat.backend.model.entities;

public class Topping {
   int idTopping;
   int toppingVar;
   int toppingPrice;

    public Topping(int toppingVar, int toppingPrice) {

        this.toppingVar = toppingVar;
        this.toppingPrice = toppingPrice;
    }
}
