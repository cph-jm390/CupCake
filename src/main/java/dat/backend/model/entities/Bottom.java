package dat.backend.model.entities;

public class Bottom {

    int botId;
    String bottomVar;

    int bottomPrice;

    public Bottom(int botId, String bottomVar, int bottomPrice) {
        this.botId=botId;
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
