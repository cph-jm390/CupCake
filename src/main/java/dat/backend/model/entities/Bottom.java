package dat.backend.model.entities;

public class Bottom {


    String bottomVar;

    int bottomPrice;

    public Bottom(String bottomVar, int bottomPrice) {
        this.bottomVar = bottomVar;
        this.bottomPrice = bottomPrice;
    }

    public String getBottomVar() {
        return bottomVar;
    }

    public int getBottomPrice() {
        return bottomPrice;
    }
}
