import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class CSVUtilsTest {

    private shoppingList listForTesting = new shoppingList("04-13-20");
    private CSVUtils csvUtils = new CSVUtils();


    @Test
    void setFilePath() {
        csvUtils.setFilePath("C:\\Users\\Shane Warga\\Desktop");
        String expected = "C:\\Users\\Shane Warga\\Desktop";
        Assert.assertEquals(expected,csvUtils.getFilePath());
    }

    @Test
    void setFileName(){
        csvUtils.setFileName("date.csv");
        String expected = "date.csv";
        Assert.assertEquals(expected,csvUtils.getFileName());
    }

    @Test
    void shoppingCartToStringArray(){
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        ArrayList<String[]> result = csvUtils.shoppingCartToStringArray(listForTesting);
        ArrayList<String[]> expected = new ArrayList<String[]>();
        int three = 3;
        double price = 1000.00;
        boolean bool = true;
        String[] item = {"Apple",Integer.toString(three),"Apple Store",Double.toString(price), Boolean.toString(bool)};
        expected.add(item);
        Assert.assertEquals(expected.get(0), result.get(0));
    }

    @Test
    void createTestCSV() throws IOException {
        csvUtils.setFilePath("E:\\NEEDNESSNOW");
        csvUtils.setFileName("test.csv");
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        csvUtils.createTestCSV(csvUtils.shoppingCartToStringArray(listForTesting));
    }


    @Test
    void createCSV() throws IOException {
        csvUtils.setFilePath("E:\\NEEDNESSNOW");
        csvUtils.setFileName("date.csv");
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        boolean returned = csvUtils.createCSV(listForTesting);
        Assert.assertEquals(true, returned);
    }
}