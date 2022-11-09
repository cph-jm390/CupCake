package dat.backend.model.entities;

public class Orderline {

     int idOrderline;
     int idOrder;
     int idTopping;
     int idBottom;
     int Quantity;
     int OrderLineTotal;

     public Orderline(int idOrder, int idTopping, int idBottom, int quantity, int orderLineTotal) {
          this.idOrder = idOrder;
          this.idTopping = idTopping;
          this.idBottom = idBottom;
          Quantity = quantity;
          OrderLineTotal = orderLineTotal;
     }
}
