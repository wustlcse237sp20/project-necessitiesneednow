import java.util.ArrayList;
import java.util.HashMap;

public class shoppingList {
    HashMap<String, Integer> totalAmountOfItem;
    HashMap<String, String> itemToStore;
    HashMap<String, Double> pricePerTime;
    HashMap<String, Boolean> subscriptions;
    ArrayList<String> items;
    String date;


    public shoppingList(String date) {
        this.date = date;
        this.totalAmountOfItem = new HashMap<>();
        this.itemToStore = new HashMap<>();
        this.pricePerTime = new HashMap<>();
        this.subscriptions = new HashMap<>();
        this.items = new ArrayList<>();

    }


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

    public ArrayList<String> getItems() {
        return items;
    }

    public String getDate() {
        return date;
    }

    public void addItem(String item, int totalAmount, String store, double price, boolean subscribed) {
        this.totalAmountOfItem.put(item, totalAmount);
        this.itemToStore.put(item, store);
        this.pricePerTime.put(item, price);
        this.subscriptions.put(item, subscribed);
        this.items.add(item);


    }

    public void listItems() {
        for (String e : items) {
            System.out.println(getItemToStore());

        }
    }

}
