package dat.backend.model.entities;

public class Bottom {

    int idBottom;
    String bottomVar;
    int bottomPrice;

    public Bottom(int idBottom, String bottomVar, int bottomPrice) {
        this.idBottom=idBottom;
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
