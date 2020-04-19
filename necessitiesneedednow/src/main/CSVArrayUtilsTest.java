import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CSVArrayUtilsTest {

    private shoppingList listForTesting = new shoppingList("03-17-00");
    private CSVArrayUtils arrayUtilsForTesting = new CSVArrayUtils();


    @Test
    void locationsToStringArray() {

        Item apple = new Item("Apple", 2, 1.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        String[] actualItemNames = arrayUtilsForTesting.LocationsToStringArray(listForTesting.itemToStore.values());
        String[] expectedItemNames = {"Apple Store", "Kroger"};
        Assert.assertEquals(expectedItemNames,actualItemNames);

    }

    @Test
    void quantityToIntegerArray() {
        Item apple = new Item("Apple", 2, 1.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        Integer[] actualQuantities = arrayUtilsForTesting.quantityToIntegerArray(listForTesting.totalAmountOfItem.values());
        Integer[] expectedQuantities = {3,5};
        Assert.assertEquals(expectedQuantities,actualQuantities);
    }


    @Test
    void subscriptionsToBooleanArray() {
        Item apple = new Item("Apple", 2, 1.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        Boolean[] actualSubscriptions = arrayUtilsForTesting.subscriptionsToBooleanArray(listForTesting.subscriptions.values());
        Boolean[] expectedSubscriptions = {true, false};
        Assert.assertEquals(expectedSubscriptions,actualSubscriptions);

    }
}