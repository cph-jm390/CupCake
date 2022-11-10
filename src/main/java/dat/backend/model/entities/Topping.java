package dat.backend.model.entities;

public class Topping {


    int topId;
   String toppingVar;
   int toppingPrice;

    public Topping(int topId, String toppingVar, int toppingPrice) {
        this.topId=topId;
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
