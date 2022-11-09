package dat.backend.model.entities;

public class Topping {

   int toppingVar;
   int toppingPrice;

    public Topping(int toppingVar, int toppingPrice) {

        this.toppingVar = toppingVar;
        this.toppingPrice = toppingPrice;
    }

    public int getToppingVar() {
        return toppingVar;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }
}
