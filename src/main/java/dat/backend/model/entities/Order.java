package dat.backend.model.entities;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
private List<Orderline> cupcakeorder = new ArrayList<>();

public Order(){

}
public void add(Orderline orderline){
    cupcakeorder.add(orderline);

}
}
