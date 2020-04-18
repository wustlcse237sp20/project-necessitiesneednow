import org.junit.Assert;
import org.junit.jupiter.api.Test;



class CSVReadUtilsTest {
    private shoppingList listForTesting = new shoppingList("04-13-20");
    private CSVReadUtils reader = new CSVReadUtils();

    @Test
    void readCSV() throws Exception {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("banana", 3, "Orange Store", 50, false);
        reader.setFullFilePath("E:\\NEEDNESSNOW\\date.csv");
        reader.setDate("04-13-20");
        shoppingList newList = reader.readCSV();
        Assert.assertEquals(listForTesting.items.get(1), newList.items.get(1));
        Assert.assertEquals(listForTesting.totalAmountOfItem.get(listForTesting.items.get(0)), newList.totalAmountOfItem.get(newList.items.get(0)));
    }
}