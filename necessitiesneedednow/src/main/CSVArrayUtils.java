import java.util.Collection;
import java.util.Set;

public class CSVArrayUtils {

    public String[] itemsToStringArray(Set<String> items){
        int index = 0;
        String[] result = new String[items.size()];
        for (String item: items) {
            result[index++] = item;
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



    public Double[] pricesToDoubleArray(Collection<Double> prices){
        int index = 0;
        Double[] result = new Double[prices.size()];
        for (Double price: prices) {
            result[index++] = price;
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
