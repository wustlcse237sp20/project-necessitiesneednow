import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class shoppingListTest {

    public shoppingList listForTesting = new shoppingList("2020-03-17");

    Item Apples = new Item("Apples", 1235, 1000.00, false);
    Item Pears = new Item("Pears", 12345, 30.00, true);

    @Test
    void getTotalAmountOfItem() {
        listForTesting.addItem(Apples, 3, "Apple Store", false);
        listForTesting.addItem(Pears, 5, "Kroger", true);
        HashMap actualHashMap = listForTesting.getTotalAmountOfItem();
        HashMap<Item, Integer> expectedHashMap = new HashMap<>();
        expectedHashMap.put(Apples,3);
        expectedHashMap.put(Pears,5);
        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }

    @Test
    void getItemToStore() {
        listForTesting.addItem(Apples, 3, "Apple Store", false);
        listForTesting.addItem(Pears, 5, "Kroger", true);
        HashMap actualHashMap = listForTesting.getItemToStore();
        HashMap<Item, String> expectedHashMap = new HashMap<>();
        expectedHashMap.put(Apples,"Apple Store");
        expectedHashMap.put(Pears, "Kroger");
        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }



    @Test
    void getSubscriptions() {
        listForTesting.addItem(Apples, 3, "Apple Store", true);
        listForTesting.addItem(Pears, 5, "Kroger", false);
        HashMap actualHashMap = listForTesting.getSubscriptions();
        HashMap<Item, Boolean> expectedHashMap = new HashMap<>();
        expectedHashMap.put(Apples, true);
        expectedHashMap.put(Pears, false);
        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }

    @Test
    void getItems() {
        listForTesting.addItem(Apples, 3, "Apple Store", false);
        listForTesting.addItem(Pears, 5, "Kroger", true);
        ArrayList<String> actualArrayList = listForTesting.getAllItemNames();
        ArrayList<String> expectedArrayList = new ArrayList<>();
        expectedArrayList.add("Apples");
        expectedArrayList.add("Pears");
        Assertions.assertEquals(expectedArrayList,actualArrayList);
    }

    @Test
    void addItem() {

           ArrayList<String> actualArrayList = listForTesting.getAllItemNames();
           ArrayList<String> expectedArrayList = new ArrayList<>();
           expectedArrayList.add("Fidget Spinner");
           Assertions.assertEquals(expectedArrayList,actualArrayList);
        }


    @Test
    void removeItem() {
        listForTesting.addItem(Apples, 3, "Apple Store", true);
        listForTesting.addItem(Pears, 5, "Kroger", false);
        listForTesting.removeItem(Apples);
        ArrayList<String> actualArrayList = listForTesting.getAllItemNames();
        ArrayList<String> expectedArrayList = new ArrayList<>();
        expectedArrayList.add("Pears");
        Assertions.assertEquals(expectedArrayList,actualArrayList);
    }

    @Test
    void removePartialItem() {
        listForTesting.addItem(Apples, 3, "Apple Store", false);
        listForTesting.addItem(Pears, 5, "Kroger", true);
        listForTesting.removePartialItem(Pears, 4);
        HashMap actualHashMap = listForTesting.getTotalAmountOfItem();
        HashMap<Item, Integer> expectedHashMap = new HashMap<>();
        expectedHashMap.put(Apples, 3);
        expectedHashMap.put(Pears, 1);
        Assertions.assertEquals(expectedHashMap,actualHashMap);
    }


    @Test
    void totalCost() {
        listForTesting.addItem(Apples, 3, "Apple Store", false);
        listForTesting.addItem(Pears, 5, "Kroger", true);
        double actualTotalCost = listForTesting.totalCost();
        double expectedTotalCost = (3*1000.00) + (5*30.00);
        Assertions.assertEquals(expectedTotalCost,actualTotalCost, 0.0000);
    }
}