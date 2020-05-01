import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class CSVUtilsTest {

    public shoppingList listForTesting = new shoppingList("04-13-20");
    public CSVUtils csvUtils = new CSVUtils();


    @Test
    void setFilePath() {
        csvUtils.setFilePath("C:\\Users\\Shane Warga\\Desktop");
        String expected = "C:\\Users\\Shane Warga\\Desktop";
        Assertions.assertEquals(expected,csvUtils.getFilePath());
    }

    @Test
    void setFileName(){
        csvUtils.setFileName("date.csv");
        String expected = "date.csv";
        Assertions.assertEquals(expected,csvUtils.getFileName());
    }

    @Test
    void shoppingCartToStringArray(){
        Item apple = new Item("Apple", 2, 1.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        ArrayList<String[]> result = csvUtils.shoppingCartToStringArray(listForTesting);
        ArrayList<String[]> expected = new ArrayList<String[]>();
        int three = 3;
        double price = 1000.00;
        boolean bool = true;
        String[] item = {"Apple",Integer.toString(three),"Apple Store",Double.toString(price), Boolean.toString(bool)};
        expected.add(item);
        Assertions.assertEquals(expected.get(0), result.get(0));
    }


    @Test
    void createCSV() throws IOException {
        csvUtils.setFilePath("E:\\NEEDNESSNOW");
        csvUtils.setFileName("date.csv");
        Item apple = new Item("Apple", 2, 1.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        boolean returned = csvUtils.createCSV(listForTesting);
        Assertions.assertEquals(true, returned);
    }
}