import java.io.*;
import java.io.IOException;

public class CSVReadUtils {

    public String fullFilePath;
    private String line = "";
    private String delim = ",";
    public String date;

    public void setFullFilePath(String fullFilePath) {
        this.fullFilePath = fullFilePath;
    }
    public void setDate(String date){
        this.date = date;
    }

    public shoppingList readCSV(){
        shoppingList loadedList = new shoppingList(date);
        File csv = new File(fullFilePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                String[] shoppingListInfo = line.split(delim);
                Item loadedItem = new Item(shoppingListInfo[0], stringToInt(shoppingListInfo[1]), stringToDouble(shoppingListInfo[2]),stringToBoolean(shoppingListInfo[3]));
                int loadedQuantity = stringToInt(shoppingListInfo[4]);
                String loadedLocation = shoppingListInfo[5];
                boolean loadedSub = stringToBoolean(shoppingListInfo[6]);
                loadedList.addItem(loadedItem,  loadedQuantity, loadedLocation, loadedSub);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return loadedList;
    }



    private double stringToDouble(String myString){
        double myDouble;
        try {
            myDouble = Double.parseDouble(myString);
        }
        catch (NumberFormatException e)
        {
            myDouble = 0.0;
        }
        return myDouble;
    }

    private int stringToInt(String myString){
        int myNumber;
        try {
            myNumber = Integer.parseInt(myString);
        }
        catch (NumberFormatException e)
        {
            myNumber = 0;
        }
        return myNumber;
    }

    private boolean stringToBoolean(String myString){
        boolean myBool;
        try {
            myBool = Boolean.parseBoolean(myString);
        }
        catch (NumberFormatException e)
        {
            myBool = false;
        }
        return myBool;
    }
}
