package dat.backend.model.entities;

public class Cupcake {

    private int quantity;
    private int idTopping;
    private int idBottom;

    private String toppingVar;

    private String bottomVar;

    public Cupcake(int idTopping, int idBottom, int quantity) {
        this.idTopping = idTopping;
        this.idBottom = idBottom;
        this.quantity = quantity;
    }

    public Cupcake(int quantity, int idTopping, int idBottom, String toppingVar, String bottomVar) {
        this.quantity = quantity;
        this.idTopping = idTopping;
        this.idBottom = idBottom;
        this.toppingVar = toppingVar;
        this.bottomVar = bottomVar;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIdTopping() {
        return idTopping;
    }

    public int getIdBottom() {
        return idBottom;
    }

    public String getToppingVar() {
        return toppingVar;
    }

    public void setToppingVar(String toppingVar) {
        this.toppingVar = toppingVar;
    }

    public String getBottomVar() {
        return bottomVar;
    }

    public void setBottomVar(String bottomVar) {
        this.bottomVar = bottomVar;
    }
}