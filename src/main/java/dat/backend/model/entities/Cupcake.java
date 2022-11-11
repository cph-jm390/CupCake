package dat.backend.model.entities;

public class Cupcake {

     private int quantity;
     private int idTopping;
     private int idBottom;

     public Cupcake(int idTopping, int idBottom, int quantity) {
          this.idTopping = idTopping;
          this.idBottom = idBottom;
          this.quantity = quantity;
     }

<<<<<<< HEAD
=======
     Topping top;
     Bottom bot;

     public int getTopID() {
          return topID;
     }

     public int getBotID() {
          return botID;
     }

>>>>>>> WTest
     public int getQuantity() {
          return quantity;
     }

     public int getIdTopping() {
          return idTopping;
     }

     public int getIdBottom() {
          return idBottom;
     }

}