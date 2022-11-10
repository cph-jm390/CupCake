package dat.backend.model.entities;

public class Topping {


    int idTopping;
   String toppingVar;
   int toppingPrice;

    public Topping(int idTopping, String toppingVar, int toppingPrice) {
        this.idTopping=idTopping;
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
