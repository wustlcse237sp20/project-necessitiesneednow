
import java.util.HashMap;


public class User {

    private String name;
    private String email;
    private String address;
    private HashMap currentInventory;
    private HashMap shoppingCart;

    public User(String name, String email, String address, HashMap currentInventory, HashMap shoppingCart) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.currentInventory = currentInventory;
        this.shoppingCart = shoppingCart;
    }

    public HashMap getCurrentInventory() {
        return currentInventory;
    }

    public String getCurrentShoppingCart() {
        return "You currently have: "+shoppingCart;
    }
}
