import java.util.Collection;
import java.util.Set;

public class CSVArrayUtils {

    public String[] itemNamesToStringArray(Set<Item> items){
        int index = 0;
        String[] result = new String[items.size()];
        for (Item item: items) {
            result[index++] = item.getProductName();
        }
        return result;
    }

    public Integer[] isbnCodeToIntArray(Set<Item> items){
        int index = 0;
        Integer[] result = new Integer[items.size()];
        for (Item item: items) {
            result[index++] =  item.getIsbnCode();
        }
        return result;
    }


    public String[] LocationsToStringArray(Collection<String> locations){
        int index = 0;
        String[] result = new String[locations.size()];
        for (String location: locations) {
            result[index++] = location;
        }
        return result;
    }

    public Integer[] quantityToIntegerArray(Collection<Integer> quantities){
        int index = 0;
        Integer[] result = new Integer[quantities.size()];
        for (Integer quantity: quantities) {
            result[index++] = quantity;
        }
        return result;
    }



    public Double[] pricesToDoubleArray(Set<Item> items){
        int index = 0;
        Double[] result = new Double[items.size()];
        for (Item item: items) {
            result[index++] = item.getPrice();
        }
        return result;
    }

    public Boolean[] isPerishableToBoolArray(Set<Item> items){
        int index = 0;
        Boolean[] result = new Boolean[items.size()];
        for (Item item: items) {
            result[index++] = item.isPerishable();
        }
        return result;
    }

    public Boolean[] subscriptionsToBooleanArray(Collection<Boolean> subscriptions){
        int index = 0;
        Boolean[] result = new Boolean[subscriptions.size()];
        for (Boolean status: subscriptions) {
            result[index++] = status;
        }
        return result;
    }





}