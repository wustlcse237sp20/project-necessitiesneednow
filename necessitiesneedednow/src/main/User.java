
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User {

    private String name;
    private String email;
    private String address;
    // private Set<Necessity> currentInventory = new HashSet<>();
    private HashMap currentInventory = new HashMap();
    // private Map<String, Integer> shoppingCart;
    private HashMap shoppingCart = new HashMap();

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

    public void getCurrentShoppingCart() {
        System.out.println("You currently have: "+shoppingCart);
    }
}
