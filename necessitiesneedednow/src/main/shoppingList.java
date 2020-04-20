import java.util.ArrayList;
import java.util.HashMap;

public class shoppingList {
    HashMap<Item, Integer> totalAmountOfItem;
    HashMap<Item, String> itemToStore;
    HashMap<Item, Boolean> subscriptions;
    private ArrayList<String> allItemNames;
    private String date;
    private Item item;
    private String itemName;
    private String itemToRemove;
    private int numberOfItemsToRemove;


    public shoppingList(String date) {
        this.date = date;
        this.totalAmountOfItem = new HashMap<>();
        this.itemToStore = new HashMap<>();
        this.subscriptions = new HashMap<>();
        this.allItemNames = new ArrayList<>();

    }


    public HashMap<Item, Integer> getTotalAmountOfItem() {
        return totalAmountOfItem;
    }

    public HashMap<Item, String> getItemToStore() {
        return itemToStore;
    }


    public HashMap<Item, Boolean> getSubscriptions() {
        return subscriptions;
    }

    public ArrayList<String> getAllItemNames() {
        return allItemNames;
    }

    public String getDate() {
        return date;
    }

    public void addItem( Item item, int totalAmount, String store, boolean subscribed) {
        this.totalAmountOfItem.put(item, totalAmount);
        this.itemToStore.put(item, store);
        this.subscriptions.put(item, subscribed);
        this.allItemNames.add(item.getProductName());


    }
    public void removeItem(Item item){
        this.item = item;
        itemName = item.getProductName();
        if(this.allItemNames.contains(itemName)){
            this.totalAmountOfItem.remove(item);
            this.itemToStore.remove(item);
            this.subscriptions.remove(item);
            this.allItemNames.remove(itemName);
            System.out.println("Item removed successfully.");
        }
        else{
            System.out.println("Looks like that item didn't exist in the cart. Did you mis-spell it, perhaps?");
            System.out.println();
        }
    }

    public void removePartialItem(Item item, int numberOfItemsToRemove){
        this.item = item;
        this.numberOfItemsToRemove = numberOfItemsToRemove;
        itemName = item.getProductName();
        if(this.allItemNames.contains(itemName)){
            int oldAmountOfItem = this.totalAmountOfItem.get(item);
            int newAmountOfItem = oldAmountOfItem - numberOfItemsToRemove;
            if(newAmountOfItem < 0){
                newAmountOfItem = 0;
            }
            this.totalAmountOfItem.replace(item,newAmountOfItem);

        }
    }
    public double totalCost(){
        double price = 0.0;
        for (Item item: totalAmountOfItem.keySet()) {
            int amountOfItem = totalAmountOfItem.get(item);
            double priceOfItem = item.getPrice();
            price += amountOfItem*priceOfItem;
        }
        return price;
    }





}
