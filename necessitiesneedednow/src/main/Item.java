public class Item {
     private String productName;
     private int isbnCode;
     private double price;
     private boolean isPerishable;

     public Item (String productName, int isbnCode, double price, boolean isPerishable){
         this.productName = productName;
         this.isbnCode = isbnCode;
         this.price = price;
         this.isPerishable = isPerishable;
     }

}
