package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Cupcake> cupcakeList = new ArrayList<>();
    String username;
    String status;
    int idShoppingcart;


    public ShoppingCart() {
    }

    public ShoppingCart(String username, String status, int idShoppingcart) {
        this.username = username;
        this.status = status;
        this.idShoppingcart = idShoppingcart;
    }
    public int getIdShoppingcart() {
        return idShoppingcart;
    }

    public void setIdShoppingcart(int idShoppingcart) {
        this.idShoppingcart = idShoppingcart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void add(Cupcake cupcake) {
        cupcakeList.add(cupcake);
    }

    public int getNumberOfCupcakes() {
        return cupcakeList.size();
    }

    public List<Cupcake> getCupcakeList() {
        return cupcakeList;
    }

}
