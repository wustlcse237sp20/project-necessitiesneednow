public class Item {
     public String productName;
     public int isbnCode;
     public double price;
     public boolean isPerishable;

     public Item (String productName, int isbnCode, double price, boolean isPerishable){
         this.productName = productName;
         this.isbnCode = isbnCode;
         this.price = price;
         this.isPerishable = isPerishable;
     }


    public String getProductName() {
        return productName;
    }

    public int getIsbnCode() {
        return isbnCode;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPerishable() {
        return isPerishable;
    }
}
