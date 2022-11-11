package dat.backend.model.entities;

import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeMapper;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

List<Cupcake> cupcakeList = new ArrayList<>();

public ShoppingCart(){

}
public void add(Cupcake cupcake){
    cupcakeList.add(cupcake);
}

public int getNumberOfCupcakes()
{
    return cupcakeList.size();
}

    public List<Cupcake> getCupcakeList() {
        return cupcakeList;
    }

    public void setCupcakeList(List<Cupcake> cupcakeList) {
        this.cupcakeList = cupcakeList;
    }

}
