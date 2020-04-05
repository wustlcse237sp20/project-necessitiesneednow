import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CSVArrayUtilsTest {

    private shoppingList listForTesting = new shoppingList("03-17-00");
    private CSVArrayUtils arrayUtilsForTesting = new CSVArrayUtils();


    @Test
    void itemsToStringArray() {

        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        String[] result = arrayUtilsForTesting.itemsToStringArray(listForTesting.totalAmountOfItem.keySet());
        String[] expectedResult = {"Apple", "Pears"};
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    void locationsToStringArray() {

        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        String[] actualItemNames = arrayUtilsForTesting.LocationsToStringArray(listForTesting.itemToStore.values());
        String[] expectedItemNames = {"Apple Store", "Kroger"};
        Assert.assertEquals(expectedItemNames,actualItemNames);

    }

    @Test
    void quantityToIntegerArray() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        Integer[] actualQuantities = arrayUtilsForTesting.quantityToIntegerArray(listForTesting.totalAmountOfItem.values());
        Integer[] expectedQuantities = {3,5};
        Assert.assertEquals(expectedQuantities,actualQuantities);
    }

    @Test
    void pricesToDoubleArray() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        Double[] actualPrices = arrayUtilsForTesting.pricesToDoubleArray((listForTesting.pricePerTime.values()));
        Double[] expectedPrices = {1000.00,30.00};
        Assert.assertEquals(expectedPrices,actualPrices);
    }

    @Test
    void subscriptionsToBooleanArray() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        Boolean[] actualSubscriptions = arrayUtilsForTesting.subscriptionsToBooleanArray(listForTesting.subscriptions.values());
        Boolean[] expectedSubscriptions = {true, false};
        Assert.assertEquals(expectedSubscriptions,actualSubscriptions);

    }
}