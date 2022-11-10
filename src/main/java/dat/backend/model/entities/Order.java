package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
private List<Orderline> orderlineList = new ArrayList<>();

public Order(){

}
public void add(Orderline orderline){
    orderlineList.add(orderline);
}

public int getNumberOfOrderlines()
{
    return orderlineList.size();
}

}
