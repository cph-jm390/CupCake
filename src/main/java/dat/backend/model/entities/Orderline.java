package dat.backend.model.entities;

public class Orderline {

     private int quantity;
     Topping top;
     Bottom bot;

     public Orderline(Topping top, Bottom bot, int quantity) {
          this.top=top;
          this.bot = bot;
          this.quantity = quantity;
     }





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