import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVUtils {

    String filePath;
    String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void createTestCSV(ArrayList<String[]> rows) throws IOException {
        File csv = new File(filePath+ "\\" +fileName);
        FileWriter writer = new FileWriter(csv);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (String[] row : rows) {
            bufferedWriter.append(String.join(",",row));
            bufferedWriter.append("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    public Boolean createCSV(shoppingList cart) throws IOException {
        File csv = new File(filePath+ "\\" +fileName);
        ArrayList<String> added = new ArrayList<String>(cart.totalAmountOfItem.keySet().size());
        ArrayList<String[]> rows = shoppingCartToStringArray(cart);
        FileWriter writer = new FileWriter(csv);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (String[] row : rows) {
            bufferedWriter.append(String.join(",",row));
            bufferedWriter.append("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        return true;
    }

    /*java doc here for the method below*/
    public ArrayList<String[]> shoppingCartToStringArray(shoppingList cart){
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
            row[1] = quantities[index].toString();
            row[2] = locations[index];
            row[3] = prices[index].toString();
            row[4] = subscriptions[index].toString();
            rows.add(row);
        }
        return rows;
    }

    private String removeSpecialCharacters(String data) {
        String editedString = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            editedString = "\"" + data + "\"";
        }
        return editedString;
    }

    private ArrayList<String[]> removeAllSpecialCharacters(ArrayList<String[]> array){
        ArrayList<String[]> result = new ArrayList<>(array.size());
        for(int arrayIndex = 0; arrayIndex < array.size(); arrayIndex++){
            for(int stringArrayIndex = 0; stringArrayIndex < array.get(arrayIndex).length; stringArrayIndex++) {
                String wordToChange = array.get(arrayIndex)[stringArrayIndex];
                String editedWord = removeSpecialCharacters(wordToChange);
                array.get(arrayIndex)[stringArrayIndex] = editedWord;
            }
        }
        return result;
    }

  /* private String formatToCSV(String[] data){
        StringJoiner joiner = new StringJoiner(",");
        for (String datum : data) {
            String s = removeSpecialCharacters(datum);
            joiner.add(s);
        }
        return joiner.toString();
    }
*/

}
