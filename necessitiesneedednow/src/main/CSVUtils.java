import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVUtils {

    String filePath;


    public String getFileName() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    private ArrayList<String[]> shoppingCartToStringArray(shoppingCart cart){
        CSVArrayUtils util = new CSVArrayUtils();
        int size = cart.totalAmountOfItem.keySet().size();
        ArrayList<String[]> rows = new ArrayList<String[]>(size);
        String[] items =  util.itemsToStringArray(cart.totalAmountOfItem.keySet());
        String[] locations = util.LocationsToStringArray(cart.itemToStore.values());
        Integer[] quantities = util.quantityToIntegerArray(cart.totalAmountOfItem.values());
        Double[] prices = util.pricesToDoubleArray(cart.pricePerTime.values());
        Boolean[] subscriptions = util.subscriptionsToBooleanArray(cart.subscriptions.values());
        String[] row = new String[5];
        for(int index = 0; index < size; index++){
            row[0] = items[index];
            row[1] = locations[index];
            row[2] = quantities[index].toString();
            row[3] = prices[index].toString();
            row[4] = subscriptions[index].toString();
            rows.add(row);
        }
        return rows;
    }


    public Boolean createCSV(shoppingCart cart) {
        File csv = new File(filePath);
        ArrayList<String[]> rows = shoppingCartToStringArray(cart);
        try (PrintWriter writer = new PrintWriter(csv)) {
            rows.stream().map(this::formatToCSV).forEach(writer::println);
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private String removeSpecialCharacters(String data){
    String editedString = data.replaceAll("\\R", " ");
    if(data.contains(",") || data.contains("\"") || data.contains("'")){
        data = data.replace("\"", "\"\"");
        editedString = "\"" + data + "\"";
    }
    return editedString;
    }

    private String formatToCSV(String[] data){
        return Stream.of(data).map(this::removeSpecialCharacters).collect(Collectors.joining(","));
    }


}
