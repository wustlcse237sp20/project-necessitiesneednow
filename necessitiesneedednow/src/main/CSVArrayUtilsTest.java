import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class CSVArrayUtilsTest {

    private shoppingList listForTesting = new shoppingList("03-17-00");
    private CSVArrayUtils arrayUtilsForTesting = new CSVArrayUtils();


    @Test
    void itemsToStringArray() {

        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        String[] result = arrayUtilsForTesting.itemsToStringArray(listForTesting.totalAmountOfItem.keySet());
        String[] expectedResult = {"Apple", "Pears"};
        Assertions.assertEquals(expectedResult, result);
    }

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
    void pricesToDoubleArray() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        Double[] actualPrices = arrayUtilsForTesting.pricesToDoubleArray((listForTesting.pricePerTime.values()));
        Double[] expectedPrices = {1000.00,30.00};
        Assertions.assertEquals(expectedPrices,actualPrices);
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