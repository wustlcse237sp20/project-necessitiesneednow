import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class shoppingList {
    HashMap<String, Integer> totalAmountOfItem;
    HashMap<String, String> itemToStore;
    HashMap<String, Double> pricePerTime;
    HashMap<String, Boolean> subscriptions;
    ArrayList<String> items;
    String date;
    String item;
    int numberOfItemsToRemove;


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
    public void removeItem(String item){
        this.item = item;
        if(this.items.contains(item)){
            this.totalAmountOfItem.remove(item);
            this.itemToStore.remove(item);
            this.pricePerTime.remove(item);
            this.subscriptions.remove(item);
            this.items.remove(item);
            System.out.println("Item removed successfully.");
        }
        else{
            System.out.println("Looks like that item didn't exist in the cart. Did you mis-spell it, perhaps?");
            System.out.println();
        }
    }

    public void removePartialItem(String item, int numberOfItemsToRemove){
        this.item = item;
        this.numberOfItemsToRemove = numberOfItemsToRemove;
        if(this.items.contains(item)){
            int oldAmountOfItem = this.totalAmountOfItem.get(item);
            int newAmountOfItem = oldAmountOfItem - numberOfItemsToRemove;
            if(newAmountOfItem < 0){
                newAmountOfItem = 0;
            }
            this.totalAmountOfItem.replace(item,newAmountOfItem);

        }
    }





}
