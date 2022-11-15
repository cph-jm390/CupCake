package dat.backend.model.entities;

public class Cupcake {

    private int quantity;
    private int idTopping;
    private int idBottom;
    private String toppingVar;
    private String bottomVar;
    private int totalPrice;
    private int idShoppingcart;

    private int cupcakeprice;
    public Cupcake(int idTopping, int idBottom, int quantity) {
        this.idTopping = idTopping;
        this.idBottom = idBottom;
        this.quantity = quantity;
    }

    public Cupcake(int quantity, int idTopping, int idBottom, String toppingVar, String bottomVar, int cupcakeprice) {
        this.quantity = quantity;
        this.idTopping = idTopping;
        this.idBottom = idBottom;
        this.toppingVar = toppingVar;
        this.bottomVar = bottomVar;
        this.cupcakeprice=cupcakeprice;
    }
    public Cupcake(int quantity, int idTopping, int idBottom, int cupcakeprice, int idShoppingcart) {
        this.quantity = quantity;
        this.idTopping = idTopping;
        this.idBottom = idBottom;
        this.cupcakeprice=cupcakeprice;
        this.idShoppingcart=idShoppingcart;
    }

    // idShoppingcart, idTopping, idBottom, Quantity, CupcakeTotalPrice



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
    public int getCupcakeprice() {
        return cupcakeprice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getIdShoppingcart() {
        return idShoppingcart;
    }
}
