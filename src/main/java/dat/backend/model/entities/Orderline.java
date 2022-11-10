package dat.backend.model.entities;

public class Orderline {

     private int quantity;
     private int topID;
     private int bottomID;

     public Orderline(int topID, int bottomID, int quantity) {
          this.topID = topID;
          this.bottomID = bottomID;
          this.quantity = quantity;
     }

     Topping top;
     Bottom bot;






     public int getQuantity() {
          return quantity;
     }

     public void setQuantity(int quantity) {
          this.quantity = quantity;
     }

     public Topping getTop() {
          return top;
     }

     public void setTop(Topping top) {
          this.top = top;
     }

     public Bottom getBot() {
          return bot;
     }

     public void setBot(Bottom bot) {
          this.bot = bot;
     }

     @Override
     public String toString() {
          return "Orderline{" +
                  "quantity=" + quantity +
                  ", top=" + top +
                  ", bot=" + bot +
                  '}';
     }
}