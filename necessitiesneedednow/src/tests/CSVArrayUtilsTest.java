import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CSVArrayUtilsTest {

    public shoppingList listForTesting = new shoppingList("03-17-00");
    public CSVArrayUtils arrayUtilsForTesting = new CSVArrayUtils();


    @Test
    void locationsToStringArray() {

        Item apple = new Item("Apple", 2, 1.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        String[] actualItemNames = arrayUtilsForTesting.LocationsToStringArray(listForTesting.itemToStore.values());
        String[] expectedItemNames = {"Apple Store", "Kroger"};
        Assertions.assertEquals(expectedItemNames,actualItemNames);

    }

    @Test
    void quantityToIntegerArray() {
        Item apple = new Item("Apple", 2, 1.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        Integer[] actualQuantities = arrayUtilsForTesting.quantityToIntegerArray(listForTesting.totalAmountOfItem.values());
        Integer[] expectedQuantities = {3,5};
        Assertions.assertEquals(expectedQuantities,actualQuantities);
    }


    @Test
    void subscriptionsToBooleanArray() {
        Item apple = new Item("Apple", 2, 1.5, true);
        listForTesting.addItem(apple, 3, "Apple Store", true);
        Boolean[] actualSubscriptions = arrayUtilsForTesting.subscriptionsToBooleanArray(listForTesting.subscriptions.values());
        Boolean[] expectedSubscriptions = {true, false};
        Assertions.assertEquals(expectedSubscriptions,actualSubscriptions);

    }
}