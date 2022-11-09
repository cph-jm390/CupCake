package dat.backend.model.entities;

public class Bottom {
    int bottomVar;
    int bottomPrice;

    public Bottom(int bottomVar, int bottomPrice) {
        this.bottomVar = bottomVar;
        this.bottomPrice = bottomPrice;
    }

    public int getBottomVar() {
        return bottomVar;
    }

    public int getBottomPrice() {
        return bottomPrice;
    }
}
