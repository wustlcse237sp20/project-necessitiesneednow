import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class shoppingListTest {

    private shoppingList listForTesting = new shoppingList("2020-03-17");

    @Test
    void getTotalAmountOfItem() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        HashMap actualHashMap = listForTesting.getTotalAmountOfItem();
        HashMap<String, Integer> expectedHashMap = new HashMap<>();
        expectedHashMap.put("Apple",3);
        expectedHashMap.put("Pears",5);
        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }

    @Test
    void getItemToStore() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        HashMap actualHashMap = listForTesting.getItemToStore();
        HashMap<String, String> expectedHashMap = new HashMap<>();
        expectedHashMap.put("Apple","Apple Store");
        expectedHashMap.put("Pears", "Kroger");
        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }

    @Test
    void getPricePerTime() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        HashMap actualHashMap = listForTesting.getPricePerTime();
        HashMap<String, Double> expectedHashMap = new HashMap<>();
        expectedHashMap.put("Apple", 1000.00);
        expectedHashMap.put("Pears", 30.00);
        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }

    @Test
    void getSubscriptions() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        HashMap actualHashMap = listForTesting.getSubscriptions();
        HashMap<String, Boolean> expectedHashMap = new HashMap<>();
        expectedHashMap.put("Apple", true);
        expectedHashMap.put("Pears", false);
        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }

    @Test
    void getItems() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        ArrayList<String> actualArrayList = listForTesting.getItems();
        ArrayList<String> expectedArrayList = new ArrayList<>();
        expectedArrayList.add("Apple");
        expectedArrayList.add("Pears");
        Assertions.assertEquals(expectedArrayList,actualArrayList);
    }

    @Test
    void addItem() {
        listForTesting.addItem("Fidget Spinner", 1, "Target", 3.00,true);
           ArrayList<String> actualArrayList = listForTesting.getItems();
           ArrayList<String> expectedArrayList = new ArrayList<>();
           expectedArrayList.add("Fidget Spinner");
           Assertions.assertEquals(expectedArrayList,actualArrayList);
        }


    @Test
    void removeItem() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        listForTesting.removeItem("Apple");
        ArrayList<String> actualArrayList = listForTesting.getItems();
        ArrayList<String> expectedArrayList = new ArrayList<>();
        expectedArrayList.add("Pears");
        Assertions.assertEquals(expectedArrayList,actualArrayList);
    }

    @Test
    void removePartialItem() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        listForTesting.removePartialItem("Pears", 4);
        HashMap actualHashMap = listForTesting.getTotalAmountOfItem();
        HashMap<String, Integer> expectedHashMap = new HashMap<>();
        expectedHashMap.put("Apple", 3);
        expectedHashMap.put("Pears", 1);
        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }


    @Test
    void totalCost() {
        listForTesting.addItem("Apple", 3, "Apple Store", 1000.00, true);
        listForTesting.addItem("Pears", 5, "Kroger", 30.00, false);
        double actualTotalCost = listForTesting.totalCost();
        double expectedTotalCost = (3*1000.00) + (5*30.00);
        Assertions.assertEquals(expectedTotalCost,actualTotalCost, 0.0000);
    }
}