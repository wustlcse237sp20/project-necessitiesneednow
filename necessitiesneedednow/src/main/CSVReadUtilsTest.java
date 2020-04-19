import org.junit.Assert;
import org.junit.jupiter.api.Test;



class CSVReadUtilsTest {
    private shoppingList listForTesting = new shoppingList("04-13-20");
    private CSVReadUtils reader = new CSVReadUtils();

    @Test
    void readCSV() throws Exception {
        Item apple = new Item("Apple", 2, 1.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        reader.setFullFilePath("E:\\NEEDNESSNOW\\date.csv");
        reader.setDate("04-13-20");
        shoppingList newList = reader.readCSV();
        Assert.assertEquals(true, newList.getAllItemNames().contains(apple.getProductName()));
    }
}