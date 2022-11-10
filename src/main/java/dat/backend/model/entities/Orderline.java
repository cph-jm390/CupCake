package dat.backend.model.entities;

public class Orderline {

     int idOrderline;
     int idOrder;
     String toppingVar;
     String bottomVar;
     int Quantity;
     int OrderLineTotal;
     Topping topping = new Topping ("Gren", 5);
     Bottom bottom = new Bottom ("håndrevet bluewaffle", 7);
          /* måske have topping+bottom som objekter med deres variable
          Topping topping = new topping

           */
     public Orderline(int idOrder, String bottomVar, String toppingVar, int quantity) {
          this.idOrder = idOrder;
          this.toppingVar = toppingVar;
          this.bottomVar = bottomVar;
          Quantity = quantity;
          OrderLineTotal = (topping.getToppingPrice()+bottom.getBottomPrice())*quantity;
     }
     /*
     public int orderLinecalc(Topping topping, Bottom bottom, int quantity){
        int orderLineTotal = (topping.getPrice+bottom.getPrice)*quantity;
                  return orderLineTotal;
     }

      */


}
