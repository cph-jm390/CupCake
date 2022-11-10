package dat.backend.model.entities;

public class Topping {

   String toppingVar;
   int toppingPrice;

    public Topping(String toppingVar, int toppingPrice) {

        this.toppingVar = toppingVar;
        this.toppingPrice = toppingPrice;
    }

    public String getToppingVar() {
        return toppingVar;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }
}
