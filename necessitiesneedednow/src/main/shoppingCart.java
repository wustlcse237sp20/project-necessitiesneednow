import java.util.HashMap;
import java.util.ArrayList;
public class shoppingCart {

    HashMap<String, Integer> totalAmountOfItem;
    HashMap<String, String> itemToStore;
    HashMap<String, Double> pricePerTime;
    HashMap<String, Boolean> subscriptions;
    ArrayList<String> items;
    int capacity;
    int currentSize;

    public HashMap<String, Integer> getTotalAmountOfItem() {
        return totalAmountOfItem;
    }

    public HashMap<String, String> getItemToStore() {
        return itemToStore;
    }

    public HashMap<String, Double> getPricePerTime() {
        return pricePerTime;
    }

    public HashMap<String, Boolean> getSubscriptions() {
        return subscriptions;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addItem(String item, int totalAmount, String store,  double price, boolean subscribed){
        this.totalAmountOfItem.put(item, totalAmount);
        this.itemToStore.put(item, store);
        this.pricePerTime.put(item, price);
        this.subscriptions.put(item, subscribed);
        this.currentSize += 1;
    }

    public void createEmptyCart(){
        this.totalAmountOfItem = new HashMap<>(this.capacity);
        this.itemToStore = new HashMap<>(this.capacity);
        this.pricePerTime = new HashMap<>(this.capacity);
        this.subscriptions = new HashMap<>(this.capacity);
        this.items = new ArrayList<>(capacity);
        this.capacity = 0;
        this.currentSize = 0;
    }
}
